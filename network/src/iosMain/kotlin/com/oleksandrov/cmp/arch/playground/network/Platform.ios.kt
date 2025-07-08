package com.oleksandrov.cmp.arch.playground.network

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual class Platform {
    actual val httpClientEngine: HttpClientEngine
        get() = Darwin.create()
}