package com.oleksandrov.cmp.arch.playground.domain.epic.usecase.impl

import com.oleksandrov.cmp.arch.playground.data.epic.repository.EPICRepository
import com.oleksandrov.cmp.arch.playground.domain.epic.mapper.EPICDomainRepoModelMapper
import com.oleksandrov.cmp.arch.playground.domain.epic.model.EPICDomainModel
import com.oleksandrov.cmp.arch.playground.domain.epic.resultLauncher
import com.oleksandrov.cmp.arch.playground.domain.epic.usecase.UpdateEPICUseCase

class UpdateEPICUseCaseImpl(
    private val repository: EPICRepository,
) : UpdateEPICUseCase {
    override suspend fun invoke(): Result<List<EPICDomainModel>?> = resultLauncher {
        repository.fetchData()?.map { EPICDomainRepoModelMapper.mapFrom(it) }
    }
}