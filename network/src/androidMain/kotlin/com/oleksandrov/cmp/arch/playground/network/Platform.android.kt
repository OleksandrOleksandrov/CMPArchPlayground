package com.oleksandrov.cmp.arch.playground.network

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

actual class Platform {
    actual val httpClientEngine: HttpClientEngine
        get() = OkHttp.create()
}