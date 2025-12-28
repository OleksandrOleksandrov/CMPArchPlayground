package com.oleksandrov.cmp.arch.playground.domain.epic.usecase.impl

import com.oleksandrov.cmp.arch.playground.data.epic.repository.EPICRepository
import com.oleksandrov.cmp.arch.playground.domain.epic.mapper.EPICDomainRepoModelMapper
import com.oleksandrov.cmp.arch.playground.domain.epic.model.EPICDomainModel
import com.oleksandrov.cmp.arch.playground.domain.epic.resultLauncher
import com.oleksandrov.cmp.arch.playground.domain.epic.usecase.GetEPICItemByIdUseCase

internal class GetEPICItemByIdUseCaseImpl(
    private val repository: EPICRepository,
) : GetEPICItemByIdUseCase {
    override suspend fun invoke(id: String): Result<EPICDomainModel?> = resultLauncher {
        repository.getEpicById(id)?.let(EPICDomainRepoModelMapper::mapFrom)
    }
}
