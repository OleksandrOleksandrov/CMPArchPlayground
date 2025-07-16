package com.oleksandrov.cmp.arch.playground.common.exception.ext

import io.ktor.client.network.sockets.SocketTimeoutException

val Throwable?.isConnectionError: Boolean //TODO replace with platform-specific implementation
    get() =//this is ConnectException ||
            //this is UnknownHostException ||
            //this is SocketException ||
            this is SocketTimeoutException ||
            (this?.cause?.isConnectionError ?: false)