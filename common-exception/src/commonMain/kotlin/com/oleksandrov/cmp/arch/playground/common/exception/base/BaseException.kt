package com.oleksandrov.cmp.arch.playground.common.exception.base

/**
 * Base class for custom exceptions in the application.
 *
 * @param message The detail message string of the exception.
 * @param originalException The original exception that caused this exception to be thrown.
 *
 * @constructor Creates a new instance of [BaseException].
 */
abstract class BaseException(
    override val message: String?,
    val originalException: Throwable?,
) : Throwable(message)