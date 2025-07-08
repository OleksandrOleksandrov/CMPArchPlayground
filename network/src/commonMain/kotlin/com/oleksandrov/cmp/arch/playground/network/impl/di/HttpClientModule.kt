package com.oleksandrov.cmp.arch.playground.network.impl.di

import com.oleksandrov.cmp.arch.playground.network.Platform
import com.oleksandrov.cmp.arch.playground.network.impl.core.client.HttpClientBuilder
import com.oleksandrov.cmp.arch.playground.network.impl.core.configuration.networkConfiguration
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import kotlin.time.Duration.Companion.seconds

val httpClientModule = module {
    singleOf(::Platform)
    singleOf(::HttpClientBuilder)

    single {
        networkConfiguration(
            hostConfig = {
                baseUrl = "https://api.nasa.gov" //TODO: Replace with buildTypes later.
            },
            timeoutConfig = {
                connectionTimeout = 30.seconds
                readTimeout = 30.seconds
                socketTimeout = 30.seconds
            },
        )
    }
    single<HttpClient> {
        get<HttpClientBuilder>().createClient(
            networkConfiguration = get(),
        )
    }
}

