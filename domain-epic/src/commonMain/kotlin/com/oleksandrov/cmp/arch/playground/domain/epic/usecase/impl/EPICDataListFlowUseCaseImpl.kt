package com.oleksandrov.cmp.arch.playground.domain.epic.usecase.impl

import com.oleksandrov.cmp.arch.playground.common.extension.withNullableReverseListMapper
import com.oleksandrov.cmp.arch.playground.data.epic.repository.EPICRepository
import com.oleksandrov.cmp.arch.playground.domain.epic.mapper.EPICDomainRepoModelMapper
import com.oleksandrov.cmp.arch.playground.domain.epic.usecase.EPICDataListFlowUseCase

class EPICDataListFlowUseCaseImpl(
    private val repository: EPICRepository,
) : EPICDataListFlowUseCase {
    override fun invoke() = repository.dataList.withNullableReverseListMapper(EPICDomainRepoModelMapper)
}