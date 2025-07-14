package com.oleksandrov.cmp.arch.playground.di

import com.oleksandrov.cmp.arch.playground.data.epic.di.dataEpicModule
import com.oleksandrov.cmp.arch.playground.domain.epic.di.domainEpicModule
import com.oleksandrov.cmp.arch.playground.epic.di.featureEarthPolychromaticImagingCameraModule
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
            featureEarthPolychromaticImagingCameraModule,
            dataEpicModule,
            domainEpicModule,
        )
    }
}