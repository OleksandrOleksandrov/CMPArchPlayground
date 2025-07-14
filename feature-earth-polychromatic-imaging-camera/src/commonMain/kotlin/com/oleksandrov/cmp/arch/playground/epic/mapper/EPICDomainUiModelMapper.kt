package com.oleksandrov.cmp.arch.playground.epic.mapper

import com.oleksandrov.cmp.arch.playground.common.mapper.BaseMapper
import com.oleksandrov.cmp.arch.playground.domain.epic.model.EPICDomainModel
import com.oleksandrov.cmp.arch.playground.epic.model.EpicUiModel

object EPICDomainUiModelMapper : BaseMapper<EPICDomainModel, EpicUiModel> {
    override fun mapFrom(model: EpicUiModel) = with(model) {
        EPICDomainModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }

    override fun mapTo(model: EPICDomainModel) = with(model) {
//        val calendar = Calendar.getInstance()
//        calendar.time = date?.parseToDate(PATTERN_DATE_DIGITS_YEAR_MONTH_DAY)
        EpicUiModel(
            identifier = identifier,
            caption = caption,
            image = "sdfasdf",
            date = date,
        )
    }
}