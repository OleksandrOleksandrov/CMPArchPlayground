package com.oleksandrov.cmp.arch.playground.network.impl.core.configuration

import com.oleksandrov.cmp.arch.playground.network.impl.core.configuration.NetworkConfiguration.Host
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

data class NetworkConfiguration internal constructor(
    val host: Host,
    val timeout: Timeout,
) {
    data class Timeout internal constructor(
        val connectionTimeout: Duration,
        val readTimeout: Duration,
        val socketTimeout: Duration,
    ) {
        class Builder {
            var connectionTimeout: Duration = 30.seconds
            var readTimeout: Duration = 30.seconds
            var socketTimeout: Duration = 30.seconds
            fun build(): Timeout {
                return Timeout(
                    connectionTimeout = connectionTimeout,
                    readTimeout = readTimeout,
                    socketTimeout = socketTimeout,
                )
            }
        }
    }

    data class Host internal constructor(
        val baseUrl: String,
    ) {
        class Builder {
            var baseUrl: String = ""

            fun build(): Host {
                require(baseUrl.isNotBlank()) { "Base url should not be empty" }
                return Host(
                    baseUrl = baseUrl,
                )
            }
        }
    }
}

fun networkConfiguration(
    hostConfig: Host.Builder.() -> Unit,
    timeoutConfig: NetworkConfiguration.Timeout.Builder.() -> Unit = {},
) = NetworkConfiguration(
    host = Host.Builder().apply(hostConfig).build(),
    timeout = NetworkConfiguration.Timeout.Builder().apply(timeoutConfig).build()
)
