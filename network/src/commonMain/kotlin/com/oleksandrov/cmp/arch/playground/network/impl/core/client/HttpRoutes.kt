package com.oleksandrov.cmp.arch.playground.network.impl.core.client

internal sealed class HttpRoutes {
    data object Epic : HttpRoutes() {
        const val EPIC = "/EPIC/api/natural?api_key=$TEST_KEY"
    }

    companion object {
        const val TEST_KEY = "3SXKZBBq6vEmA7yamongiBY66cvnlx1JbeeDOtZu"
    }
}
