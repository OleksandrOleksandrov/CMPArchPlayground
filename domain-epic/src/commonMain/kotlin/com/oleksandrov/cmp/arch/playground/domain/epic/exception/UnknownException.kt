package com.oleksandrov.cmp.arch.playground.domain.epic.exception

class UnknownException(
    override val message: String? = null,
    originalException: Exception? = null,
) : BaseDomainException(message, originalException)
