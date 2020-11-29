package com.gitpub.rosatomtasktracker.ui.main.taskpage

import android.Manifest
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.gitpub.rosatomtasktracker.R
import com.gitpub.rosatomtasktracker.databinding.FragmentTaskPageBinding
import com.gitpub.rosatomtasktracker.di.fragmentViewModel
import com.gitpub.rosatomtasktracker.model.domain.Priorities
import com.gitpub.rosatomtasktracker.model.domain.Task
import com.gitpub.rosatomtasktracker.model.items.TaskCommentItem
import com.gitpub.rosatomtasktracker.model.util.Result
import com.gitpub.rosatomtasktracker.ui.utils.*
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import org.kodein.di.DIAware
import org.kodein.di.android.x.di

class TaskPageFragment : Fragment(R.layout.fragment_task_page), DIAware {

    override val di by di()

    private val navArgs by navArgs<TaskPageFragmentArgs>()

    private val viewModel: TaskPageViewModel by fragmentViewModel()
    private val binding by viewBinding(FragmentTaskPageBinding::bind)

    private var mIsRecording = false

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (!isGranted) {
                Snackbar.make(
                    binding.root,
                    "Разрешите приложению записывать аудио",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

    private val launchRecordAudioPermission =
        { requestPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO) }

    private val commentAdapter = ItemListAdapter().apply {
        addDelegates(AdapterDelegateRegistry.TaskComment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUi()
        initializeViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.resume()
    }

    private fun initializeUi() {
        binding.apply {
            commentsContainer.adapter = commentAdapter
            commentInputLayout.setEndIconOnClickListener {
                if (!mIsRecording) {
                    startRecording()
                } else {
                    stopRecording()
                }
            }
            sendComment.setOnClickListener {
                val comment = commentText.text.toString()
                if (!comment.isBlank()) {
                    viewModel.sendComment(comment)
                    commentText.text = null
                }
            }
            toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
            submitTask.setOnClickListener {
                val action = TaskPageFragmentDirections
                    .actionTaskPageFragmentToSubmitTaskFragment(navArgs.taskId)
                findNavController().navigate(action)
            }
            cancelTask.setOnClickListener {
                viewModel.cancelTask()
            }
        }
    }

    private fun initializeViewModel() {
        viewModel.apply {
            loadTask(navArgs.taskId)
            taskData.observe(viewLifecycleOwner) { result ->
                when (result) {
                    is Result.Success -> binding.displayTaskData(result.data)
                    is Result.Error -> Unit
                }
            }
            speechData.observe(viewLifecycleOwner) { text ->
                when (text) {
                    is Result.Success -> binding.commentText.append(text.data)
                    is Result.Error -> Snackbar.make(
                        binding.root,
                        "Не удалось распознать текст",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }

    }

    private fun startRecording() {
        mIsRecording = viewModel.recordAudio(binding.root.context)
        if (!mIsRecording) {
            requestRecordAudioPermission()
        } else {
            binding.commentInputLayout.setEndIconTintList(
                ColorStateList.valueOf(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.orange,
                        null
                    )
                )
            )
        }
    }

    private fun stopRecording() {
        mIsRecording = false
        viewModel.stopRecording()
        binding.commentInputLayout.setEndIconTintList(
            ColorStateList.valueOf(
                ResourcesCompat.getColor(
                    resources,
                    R.color.blue,
                    null
                )
            )
        )
    }

    private fun requestRecordAudioPermission() {
        val recordPermitted = ContextCompat.checkSelfPermission(
            binding.root.context,
            Manifest.permission.RECORD_AUDIO
        )
        if (recordPermitted == PackageManager.PERMISSION_GRANTED) {
            Snackbar.make(binding.root, "Не удалось записать звук", Snackbar.LENGTH_LONG).show()
            return
        }
        context?.also {
            MaterialAlertDialogBuilder(it)
                .setTitle("Нужно разрешение")
                .setMessage("Разрешите приложению записывать аудио, чтобы преобразовывать его в текст")
                .setPositiveButton("Ок") { _, _ -> launchRecordAudioPermission() }
                .setNegativeButton("Отменить") { _, _ -> }
                .show()
        }

    }

    private fun answerClicked(comment: TaskCommentItem) {
        binding.apply {
            commentText.append(comment.authorName)
            commentInputLayout.requestFocus()
        }
    }

    private fun FragmentTaskPageBinding.displayTaskData(item: Task) {
        title.text = item.header
        status.apply {
            text = item.status.code
            setTextColor(item.status.toTextColor(resources))
            backgroundTintList = item.status.toTextBackground(resources)
        }
        type.text = item.type.code
        priority.isVisible = item.priority == Priorities.TopPriority
        timeCreated.text = item.createdAt.toString("HH:MM")
        dateCreated.text = item.createdAt.toString("dd MMM yyyy")

        executiveText.text = item.assignee.name
        priorityText.text = item.priority.name
        dueDateText.text = item.dateTo.toString("dd MMM yyyy")
        taskInfo.text = item.info

        attachmentsContainer.removeAllViews()
        item.attachments?.map { it.createAttachmentView(root.context) }
            .also { attachmentsContainer.isVisible = !it.isNullOrEmpty() }
            ?.forEach(attachmentsContainer::addView)

        commentAdapter.setItemList(
            item.comments?.map { TaskCommentItem.fromDomain(it, ::answerClicked) }
                ?: listOf()
        )

    }
}