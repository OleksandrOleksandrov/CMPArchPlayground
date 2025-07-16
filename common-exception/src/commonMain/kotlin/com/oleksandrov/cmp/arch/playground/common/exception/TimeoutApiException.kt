package com.oleksandrov.cmp.arch.playground.common.exception

/**
 * A custom exception class representing a timeout error.
 *
 * This exception is thrown when a request exceeds the allocated time for completion,
 * usually due to network delays or server unresponsiveness. It extends [ApiException]
 * but does not carry specific error details like message, status code, or timestamp.
 * Instead, it focuses on the occurrence of a timeout, encapsulating the original
 * exception that caused it, if available.
 *
 * @property originException The original exception that triggered this timeout error, if any.
 */
class TimeoutApiException(
    val originException: Exception? = null,
) : ApiException(cause = originException) {

    /**
     * Returns a string representation of the [TimeoutApiException] instance,
     * detailing the original exception (if available) that led to the timeout.
     */
    override fun toString(): String = "TimeoutApiException(originException=${
        originException?.let {
            it::class.simpleName + ": " + it.message
        } ?: "N/A"
    })"
}
