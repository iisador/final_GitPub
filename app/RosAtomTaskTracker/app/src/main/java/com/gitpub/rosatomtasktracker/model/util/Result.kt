package com.gitpub.rosatomtasktracker.model.util

import retrofit2.HttpException
import retrofit2.Response

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

fun <T, R> Result<T>.map(mapper: (T) -> R) = when (this) {
    is Result.Success -> Result.Success(mapper(data))
    is Result.Error -> this
}

fun <T> Response<T>.mapToResult() = if (isSuccessful) {
    Result.Success(body())
} else {
    Result.Error(HttpException(this))
}
