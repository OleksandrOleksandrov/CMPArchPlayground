package com.oleksandrov.cmp.arch.playground.presentation.core.styling

interface Platform {
    val name: String
    val version: Int get() = 0
    val isPlatform31Plus: Boolean get() = true
}
expect fun platform(): Platform