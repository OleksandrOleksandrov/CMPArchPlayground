package com.oleksandrov.cmp.arch.playground.network.impl.core.client

import com.oleksandrov.cmp.arch.playground.network.Platform
import com.oleksandrov.cmp.arch.playground.network.impl.core.configuration.NetworkConfiguration
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json

internal class HttpClientBuilder(
    private val platform: Platform,
) {
    fun createClient(
        networkConfiguration: NetworkConfiguration,
    ) = HttpClient(platform.httpClientEngine) {
        val (hostConfig, timeoutConfig) = networkConfiguration

        expectSuccess = true

        install(HttpTimeout) {
            requestTimeoutMillis = timeoutConfig.readTimeout.inWholeMilliseconds
            connectTimeoutMillis = timeoutConfig.connectionTimeout.inWholeMilliseconds
            socketTimeoutMillis = timeoutConfig.socketTimeout.inWholeMilliseconds
        }

        install(ContentNegotiation) {
            json()
        }
        install(Logging)

        defaultRequest {
            url(hostConfig.baseUrl)
        }
    }
}
