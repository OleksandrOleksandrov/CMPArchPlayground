package com.oleksandrov.cmp.arch.playground

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform