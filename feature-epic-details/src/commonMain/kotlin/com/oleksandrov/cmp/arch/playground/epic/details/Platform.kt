package com.oleksandrov.cmp.arch.playground.epic.details

import io.ktor.client.engine.HttpClientEngine

expect class Platform() {
    val httpClientEngine: HttpClientEngine
}