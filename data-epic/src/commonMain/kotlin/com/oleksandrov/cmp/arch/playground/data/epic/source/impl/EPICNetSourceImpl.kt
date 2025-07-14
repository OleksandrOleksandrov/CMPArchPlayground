package com.oleksandrov.cmp.arch.playground.data.epic.source.impl

import com.oleksandrov.cmp.arch.playground.data.epic.source.EPICNetSource
import com.oleksandrov.cmp.arch.playground.network.impl.core.client.HttpRoutes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class EPICNetSourceImpl(
    private val client: HttpClient,
) : EPICNetSource {
    override suspend fun fetchEpic(): HttpResponse = client.get(HttpRoutes.Epic.EPIC).body()
}