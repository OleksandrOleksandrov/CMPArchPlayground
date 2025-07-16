package com.oleksandrov.cmp.arch.playground.domain.epic

import com.oleksandrov.cmp.arch.playground.common.exception.ApiException
import com.oleksandrov.cmp.arch.playground.domain.epic.exception.BaseDomainException
import com.oleksandrov.cmp.arch.playground.common.exception.ConnectionApiException
import com.oleksandrov.cmp.arch.playground.domain.epic.exception.NetworkException
import com.oleksandrov.cmp.arch.playground.common.exception.ServerErrorApiException
import com.oleksandrov.cmp.arch.playground.domain.epic.exception.ServerException
import com.oleksandrov.cmp.arch.playground.common.exception.TimeoutApiException
import com.oleksandrov.cmp.arch.playground.common.exception.UnknownApiException
import com.oleksandrov.cmp.arch.playground.domain.epic.exception.UnknownException

typealias Optional = Result<Unit>

suspend fun <T> resultLauncher(action: suspend () -> T): Result<T> = try {
    Result.success(action())
} catch (e: Exception) {
    Result.failure(handleException(e))
}

/**
 * Handles exceptions by converting them into a `BaseDomainException`.
 *
 * @param cause The exception that was thrown.
 * @return A `BaseDomainException` representing the error. If the `cause` is already a `BaseDomainException`, it is returned as-is.
 *         Otherwise, it returns an `UnknownException` wrapping the original exception.
 */
private fun handleException(
    cause: Throwable,
): BaseDomainException = when (cause) {
    //region api
    is ApiException -> when (cause) {
        is ServerErrorApiException -> ServerException()
        is ConnectionApiException, is TimeoutApiException, is UnknownApiException -> NetworkException()
        else -> UnknownException()
    }
    //endregion api

    else -> UnknownException()
}
