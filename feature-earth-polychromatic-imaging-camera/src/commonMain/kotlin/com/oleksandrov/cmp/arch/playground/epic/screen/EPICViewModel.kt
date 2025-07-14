package com.oleksandrov.cmp.arch.playground.epic.screen

import com.oleksandrov.cmp.arch.playground.common.extension.withNullableListMapper
import com.oleksandrov.cmp.arch.playground.domain.epic.usecase.EPICDataListFlowUseCase
import com.oleksandrov.cmp.arch.playground.domain.epic.usecase.UpdateEPICUseCase
import com.oleksandrov.cmp.arch.playground.epic.mapper.EPICDomainUiModelMapper
import com.oleksandrov.cmp.arch.playground.epic.model.PictureOfDayUiModel
import com.oleksandrov.cmp.arch.playground.presentation.core.platform.base.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.flowOf


class EPICViewModel(
    private val updateEPICUseCase: UpdateEPICUseCase,
    ePICDataListFlowUseCase: EPICDataListFlowUseCase,
//    private val updateAPODUseCase: UpdateAPODUseCase,
//    aPODDataFlowUseCase: APODDataFlowUseCase,
) : BaseViewModel() {

    val epicList = ePICDataListFlowUseCase().withNullableListMapper(EPICDomainUiModelMapper)
//    val apod = aPODDataFlowUseCase().withMapper(APODDomainUiModelMapper)

    val apod = flowOf<PictureOfDayUiModel>()

    init {
        launch {
//            updateAPODUseCase()
            updateEPICUseCase()
        }
    }
}