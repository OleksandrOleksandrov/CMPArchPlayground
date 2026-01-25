package com.oleksandrov.cmp.arch.playground.domain.epic.usecase

import com.oleksandrov.cmp.arch.playground.domain.epic.model.EPICDomainModel

interface GetEPICItemByIdUseCase {
    suspend operator fun invoke(id: String): Result<EPICDomainModel?>
}