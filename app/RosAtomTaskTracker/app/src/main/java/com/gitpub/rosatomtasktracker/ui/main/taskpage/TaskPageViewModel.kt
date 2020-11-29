package com.gitpub.rosatomtasktracker.ui.main.taskpage

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.*
import com.gitpub.rosatom.apis.DefaultApi
import com.gitpub.rosatom.models.CommentResource
import com.gitpub.rosatomtasktracker.misc.OnlyAudioRecorder
import com.gitpub.rosatomtasktracker.model.domain.Task
import com.gitpub.rosatomtasktracker.model.util.Result
import com.gitpub.rosatomtasktracker.model.util.mapToResult
import com.gitpub.rosatomtasktracker.service.repository.tasks.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class TaskPageViewModel(
    private val taskRepository: TaskRepository,
    private val api: DefaultApi
) : ViewModel() {

    private var mRecordFile: File? = null

    private var mTaskId: Long? = null
        set(value) {
            field = value
            if (value != null) {
                mTaskIdData.postValue(value)
            }
        }
    private val mTaskIdData: MutableLiveData<Long> = MutableLiveData()
    private val mSpeech: MutableLiveData<Unit> = MutableLiveData()

    val taskData: LiveData<Result<Task>> = mTaskIdData.switchMap {
        liveData {
            val data = taskRepository.getTaskById(it)
            emit(data)
        }
    }

    val speechData: LiveData<Result<String?>> = mSpeech.switchMap {
        liveData {
            val file = mRecordFile ?: return@liveData
            val part = MultipartBody.Part.createFormData(
                "speech",
                "record.wav",
                file.asRequestBody("audio/wav".toMediaType())
            )
            val data = api.convertUsingPOST(part)
            emit(data.mapToResult())
        }
    }

    init {
        OnlyAudioRecorder.instance.setOnRecordedCallback {
            mRecordFile = it
            mSpeech.postValue(Unit)
        }
    }


    fun loadTask(id: Long) {
        mTaskId = id
    }

    fun recordAudio(context: Context): Boolean {
        val recordPermitted = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.RECORD_AUDIO
        )
        if (recordPermitted != PackageManager.PERMISSION_GRANTED) {
            return false
        }

        OnlyAudioRecorder.instance.startRecord()
        return true
    }

    fun stopRecording() {
        OnlyAudioRecorder.instance.stopRecord()
    }

    fun sendComment(comment: String) {
        mTaskId?.also {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    api.commentUsingPOST(it, CommentResource(1, comment))
                    mTaskId = mTaskId
                }
            }
        }
    }

    fun resume() {
        mTaskId = mTaskId
        OnlyAudioRecorder.instance.setOnRecordedCallback {
            mRecordFile = it
            mSpeech.postValue(Unit)
        }
    }

    fun cancelTask() {
        val id = mTaskId ?: return
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                api.commentUsingPOST(id, CommentResource(1, "Задача отменена"))
                api.updateTaskStatus(id, 5)
                mTaskId = mTaskId
            }
        }
    }

}