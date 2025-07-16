package com.oleksandrov.cmp.arch.playground.domain.epic.usecase

import com.oleksandrov.cmp.arch.playground.domain.epic.model.EPICDomainModel

interface UpdateEPICUseCase {
    suspend operator fun invoke() : Result<List<EPICDomainModel>?>
}