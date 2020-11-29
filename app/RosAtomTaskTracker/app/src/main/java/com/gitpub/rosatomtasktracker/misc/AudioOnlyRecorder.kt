package com.gitpub.rosatomtasktracker.misc

import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

/**
 *@author :
 *@date : 2020/1/17
 *@description :Audio only class
 */
class OnlyAudioRecorder private constructor() {
    //1. Set recording related parameters, audio acquisition source, sampling rate, channel and data format
    //2. Calculate the minimum recording buffer size
    //3. Create audioRecord object
    //4. Start recording
    //5. Create files to save PCM files
    //6. Close recording and release related resources after recording
    //7. Convert pcm file to WAV file

    companion object {
        private const val TAG: String = "OnlyAudioRecorder"
        private const val AudioSource = MediaRecorder.AudioSource.MIC//Student source
        private const val SampleRate = 16000//sampling rate
        private const val Channel = AudioFormat.CHANNEL_IN_MONO//Mono channel
        private const val EncodingType = AudioFormat.ENCODING_PCM_16BIT//data format

        //Single example of double check
        val instance: OnlyAudioRecorder by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            OnlyAudioRecorder()
        }
    }

    private var bufferSizeInByte: Int = 0//Minimum recording buffer
    private var audioRecorder: AudioRecord? = null//Recording object
    private var isRecord = false
    private var onRecordedCallback: (File) -> Unit = {}

    private var mRecordFile = File.createTempFile("record", ".pcm")
    private var mFinalFile = File.createTempFile("record", ".wav")

    private fun initRecorder() {//Initializing the audioRecord object

        bufferSizeInByte = AudioRecord.getMinBufferSize(SampleRate, Channel, EncodingType)
        audioRecorder = AudioRecord(
            AudioSource, SampleRate, Channel,
            EncodingType, bufferSizeInByte
        )
    }

    fun startRecord(): Int {

        if (isRecord) {
            return -1
        } else {

            audioRecorder ?: initRecorder()
            audioRecorder?.startRecording()
            isRecord = true

            AudioRecordToFile().start()
            return 0
        }
    }

    fun stopRecord() {

        audioRecorder?.stop()
        audioRecorder?.release()
        isRecord = false
        audioRecorder = null
    }

    fun setOnRecordedCallback(callback: (File) -> Unit) {
        onRecordedCallback = callback
    }

    private fun writeDateTOFile() {

        var audioData = ByteArray(bufferSizeInByte)
        mRecordFile.delete()
        mRecordFile = File.createTempFile("record", ".wav")
        val out = BufferedOutputStream(FileOutputStream(mRecordFile))
        var length = 0
        while (isRecord && audioRecorder != null) {
            length = audioRecorder!!.read(audioData, 0, bufferSizeInByte)//Get audio data
            if (AudioRecord.ERROR_INVALID_OPERATION != length) {
                out.write(audioData, 0, length)//write file
                out.flush()
            }
        }
        out.close()
    }

    //Converting pcm files to WAV files
    private fun copyWaveFile(pcmFile: File, wavFile: File) {

        var fileIn = FileInputStream(pcmFile)
        var fileOut = FileOutputStream(wavFile)
        val data = ByteArray(bufferSizeInByte)
        val totalAudioLen = fileIn.channel.size()
        val totalDataLen = totalAudioLen + 36
        writeWaveFileHeader(fileOut, totalAudioLen, totalDataLen)
        var count = fileIn.read(data, 0, bufferSizeInByte)
        while (count != -1) {
            fileOut.write(data, 0, count)
            fileOut.flush()
            count = fileIn.read(data, 0, bufferSizeInByte)
        }
        fileIn.close()
        fileOut.close()
        onRecordedCallback(wavFile)
    }

    //Add file header in WAV format
    private fun writeWaveFileHeader(
        out: FileOutputStream, totalAudioLen: Long,
        totalDataLen: Long
    ) {

        val channels = 1
        val byteRate = 16 * SampleRate * channels / 8
        val header = ByteArray(44)
        header[0] = 'R'.toByte()
        header[1] = 'I'.toByte()
        header[2] = 'F'.toByte()
        header[3] = 'F'.toByte()
        header[4] = (totalDataLen and 0xff).toByte()
        header[5] = (totalDataLen shr 8 and 0xff).toByte()
        header[6] = (totalDataLen shr 16 and 0xff).toByte()
        header[7] = (totalDataLen shr 24 and 0xff).toByte()
        header[8] = 'W'.toByte()
        header[9] = 'A'.toByte()
        header[10] = 'V'.toByte()
        header[11] = 'E'.toByte()
        header[12] = 'f'.toByte() // 'fmt ' chunk
        header[13] = 'm'.toByte()
        header[14] = 't'.toByte()
        header[15] = ' '.toByte()
        header[16] = 16 // 4 bytes: size of 'fmt ' chunk
        header[17] = 0
        header[18] = 0
        header[19] = 0
        header[20] = 1 // format = 1
        header[21] = 0
        header[22] = channels.toByte()
        header[23] = 0
        header[24] = (SampleRate and 0xff).toByte()
        header[25] = (SampleRate shr 8 and 0xff).toByte()
        header[26] = (SampleRate shr 16 and 0xff).toByte()
        header[27] = (SampleRate shr 24 and 0xff).toByte()
        header[28] = (byteRate and 0xff).toByte()
        header[29] = (byteRate shr 8 and 0xff).toByte()
        header[30] = (byteRate shr 16 and 0xff).toByte()
        header[31] = (byteRate shr 24 and 0xff).toByte()
        header[32] = (2 * 16 / 8).toByte() // block align
        header[33] = 0
        header[34] = 16 // bits per sample
        header[35] = 0
        header[36] = 'd'.toByte()
        header[37] = 'a'.toByte()
        header[38] = 't'.toByte()
        header[39] = 'a'.toByte()
        header[40] = (totalAudioLen and 0xff).toByte()
        header[41] = (totalAudioLen shr 8 and 0xff).toByte()
        header[42] = (totalAudioLen shr 16 and 0xff).toByte()
        header[43] = (totalAudioLen shr 24 and 0xff).toByte()
        out.write(header, 0, 44)
    }

    private inner class AudioRecordToFile : Thread() {

        override fun run() {
            super.run()

            writeDateTOFile()
            copyWaveFile(mRecordFile, mFinalFile)
        }
    }
}