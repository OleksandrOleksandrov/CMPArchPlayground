package com.oleksandrov.cmp.arch.playground.domain.epic.exception

import com.oleksandrov.cmp.arch.playground.common.exception.base.BaseException

/**
 * Base class for custom domain exceptions in the application.
 *
 * @param message The detail message string of the exception.
 * @param originalException The original exception that caused this exception to be thrown.
 *
 * @constructor Creates a new instance of [BaseDomainException].
 */
sealed class BaseDomainException(
    override val message: String?,
    originalException: Exception?,
) : BaseException(message, originalException)
