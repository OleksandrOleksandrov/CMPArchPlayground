package com.oleksandrov.cmp.arch.playground.epic.details.di

import com.oleksandrov.cmp.arch.playground.epic.details.screen.EpicDetailsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureEPICDetailsModule = module {
     viewModelOf(::EpicDetailsViewModel)
}