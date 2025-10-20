package com.oleksandrov.cmp.arch.playground.network.impl.core.client

sealed class HttpRoutes { // TODO: make it internal
    data object Epic : HttpRoutes() {
        const val EPIC = "/api/natural?api_key=$TEST_KEY"
    }

    companion object {
        const val TEST_KEY = "3SXKZBBq6vEmA7yamongiBY66cvnlx1JbeeDOtZu" //TODO: move it to secure properties.
    }
}
