package com.oleksandrov.cmp.arch.playground.domain.epic.usecase.impl

import com.oleksandrov.cmp.arch.playground.data.epic.repository.EPICRepository
import com.oleksandrov.cmp.arch.playground.domain.epic.usecase.UpdateEPICUseCase

class UpdateEPICUseCaseImpl(
    private val repository: EPICRepository,
) : UpdateEPICUseCase {
    override suspend fun invoke() = repository.updateData()
}