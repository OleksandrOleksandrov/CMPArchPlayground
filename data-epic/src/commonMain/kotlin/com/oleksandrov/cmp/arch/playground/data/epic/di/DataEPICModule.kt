package com.oleksandrov.cmp.arch.playground.data.epic.di

import com.oleksandrov.cmp.arch.playground.data.epic.repository.EPICRepository
import com.oleksandrov.cmp.arch.playground.data.epic.repository.impl.EPICRepositoryImpl
import com.oleksandrov.cmp.arch.playground.data.epic.source.EPICNetSource
import com.oleksandrov.cmp.arch.playground.data.epic.source.impl.EPICNetSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataEpicModule = module {
    singleOf(::EPICNetSourceImpl) bind EPICNetSource::class
    singleOf(::EPICRepositoryImpl) bind EPICRepository::class
}