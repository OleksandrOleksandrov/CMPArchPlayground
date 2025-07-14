package com.oleksandrov.cmp.arch.playground.epic.di

import com.oleksandrov.cmp.arch.playground.epic.screen.EPICViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureEarthPolychromaticImagingCameraModule = module {
     viewModelOf(::EPICViewModel)
}