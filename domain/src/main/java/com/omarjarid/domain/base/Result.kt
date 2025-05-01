package com.omarjarid.domain.base

sealed class Result<out T> {

    data class Success<T>(val value: T) : Result<T>()

    data class Failure(val e: Exception) : Result<Nothing>()
}