package com.oleksandrov.cmp.arch.playground.common.exception

/**
 * A custom exception class representing a server error (HTTP 500 or higher).
 *
 * This exception is thrown when the server encounters an internal error or other
 * issue that prevents it from fulfilling the request. It extends [ApiException] and
 * includes additional details such as the error message, status code, status message,
 * timestamp, and path related to the failed request.
 *
 * @property error The error message associated with the server error response.
 * @property statusCode The HTTP status code of the response, typically 500 or higher.
 * @property statusMessage A message describing the status of the response.
 * @property originException The original exception that triggered this server error, if any.
 */
class ServerErrorApiException(
    val error: String?,
    val statusCode: Int?,
    val statusMessage: String?,
    val originException: Exception? = null,
) : ApiException(error, statusCode, statusMessage, originException) {

    /**
     * Returns a string representation of the [ServerErrorApiException] instance,
     * including details about the error, status code, status message, timestamp, path,
     * and the original exception (if available).
     */
    override fun toString(): String = "ServerErrorApiException(error=$error, statusCode=${statusCode ?: "N/A"}, " +
        "statusMessage=$statusMessage, " +
        "originException=${
            originException?.let {
                it::class.simpleName + ": " + it.message
            } ?: "N/A"
        })"
}
