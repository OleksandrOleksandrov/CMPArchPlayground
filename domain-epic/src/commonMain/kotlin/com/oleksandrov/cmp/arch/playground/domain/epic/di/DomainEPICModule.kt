package com.oleksandrov.cmp.arch.playground.domain.epic.di

import com.oleksandrov.cmp.arch.playground.domain.epic.usecase.EPICDataListFlowUseCase
import com.oleksandrov.cmp.arch.playground.domain.epic.usecase.UpdateEPICUseCase
import com.oleksandrov.cmp.arch.playground.domain.epic.usecase.impl.EPICDataListFlowUseCaseImpl
import com.oleksandrov.cmp.arch.playground.domain.epic.usecase.impl.UpdateEPICUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val domainEpicModule = module {
    singleOf(::UpdateEPICUseCaseImpl) bind UpdateEPICUseCase::class
    singleOf(::EPICDataListFlowUseCaseImpl) bind EPICDataListFlowUseCase::class
}