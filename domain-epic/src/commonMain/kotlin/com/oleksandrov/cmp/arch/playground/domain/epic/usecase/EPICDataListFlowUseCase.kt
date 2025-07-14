package com.oleksandrov.cmp.arch.playground.domain.epic.usecase

import com.oleksandrov.cmp.arch.playground.domain.epic.model.EPICDomainModel
import kotlinx.coroutines.flow.Flow

interface EPICDataListFlowUseCase {
    operator fun invoke(): Flow<List<EPICDomainModel>?>
}