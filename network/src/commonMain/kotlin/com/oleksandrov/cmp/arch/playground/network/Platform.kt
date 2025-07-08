package com.oleksandrov.cmp.arch.playground.network

import io.ktor.client.engine.HttpClientEngine

expect class Platform() {
    val httpClientEngine: HttpClientEngine
}
