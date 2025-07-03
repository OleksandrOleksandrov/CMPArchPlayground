package com.oleksandrov.cmp.arch.playground.di

import com.oleksandrov.cmp.arch.playground.AppViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::AppViewModel)
}