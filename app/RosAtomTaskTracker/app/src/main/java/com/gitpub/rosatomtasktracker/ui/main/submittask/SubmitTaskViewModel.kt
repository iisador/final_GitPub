package com.gitpub.rosatomtasktracker.ui.main.submittask

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.*
import com.gitpub.rosatom.apis.DefaultApi
import com.gitpub.rosatom.models.CommentResource
import com.gitpub.rosatomtasktracker.misc.OnlyAudioRecorder
import com.gitpub.rosatomtasktracker.model.util.Result
import com.gitpub.rosatomtasktracker.model.util.mapToResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class SubmitTaskViewModel(private val api: DefaultApi) : ViewModel() {

    private var mRecordFile: File? = null
    private val mSpeech: MutableLiveData<Unit> = MutableLiveData()

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

    private val _submitted = MutableLiveData<Unit>()
    val submitted: LiveData<Unit> = _submitted

    fun submit(id: Long, comment: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                api.commentUsingPOST(id, CommentResource(1, comment, true))
                api.updateTaskStatus(id, 3)
                _submitted.postValue(Unit)
            }
        }
    }

    init {
        OnlyAudioRecorder.instance.setOnRecordedCallback {
            mRecordFile = it
            mSpeech.postValue(Unit)
        }
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


}