package com.oleksandrov.cmp.arch.playground.data.epic.source

import io.ktor.client.statement.HttpResponse

interface EPICNetSource {
    suspend fun fetchEpic(): HttpResponse
}