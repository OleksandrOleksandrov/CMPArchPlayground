package com.oleksandrov.cmp.arch.playground.domain.epic.exception

class ServerException(
    override val message: String? = null,
    originalException: Exception? = null,
) : BaseDomainException(message, originalException)
