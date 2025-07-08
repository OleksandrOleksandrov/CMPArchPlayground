package com.oleksandrov.cmp.arch.playground.di

import com.oleksandrov.cmp.arch.playground.network.impl.di.httpClientModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(
    config: KoinAppDeclaration? = null
) {
    startKoin {
        config?.invoke(this)
        modules(
            appModule,
            httpClientModule,
        )
    }
}