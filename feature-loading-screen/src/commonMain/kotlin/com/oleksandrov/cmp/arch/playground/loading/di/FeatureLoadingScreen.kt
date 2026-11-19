package com.oleksandrov.cmp.arch.playground.loading.di

import com.oleksandrov.cmp.arch.playground.loading.screen.LoadingScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureLoadingScreenModule = module {
    viewModelOf(::LoadingScreenViewModel)
}