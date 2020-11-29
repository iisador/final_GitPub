package com.gitpub.rosatomtasktracker.ui.main.submittask

import android.Manifest
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.gitpub.rosatomtasktracker.R
import com.gitpub.rosatomtasktracker.databinding.FragmentSubmitTaskBinding
import com.gitpub.rosatomtasktracker.di.fragmentViewModel
import com.gitpub.rosatomtasktracker.model.util.Result
import com.gitpub.rosatomtasktracker.ui.utils.viewBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import org.kodein.di.DIAware
import org.kodein.di.android.x.di

class SubmitTaskFragment : Fragment(R.layout.fragment_submit_task), DIAware {

    override val di by di()

    private val navArgs by navArgs<SubmitTaskFragmentArgs>()
    private val viewModel: SubmitTaskViewModel by fragmentViewModel()
    private val binding by viewBinding(FragmentSubmitTaskBinding::bind)

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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUi()
        initializeViewModel()
    }

    private fun initializeViewModel() {
        viewModel.apply {
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
            submitted.observe(viewLifecycleOwner) {
                findNavController().popBackStack()
            }
        }
    }

    private fun initializeUi() {
        binding.apply {
            commentInputLayout.setEndIconOnClickListener {
                if (!mIsRecording) {
                    startRecording()
                } else {
                    stopRecording()
                }
            }
            submit.setOnClickListener {
                viewModel.submit(navArgs.taskId, commentText.text.toString())
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
}