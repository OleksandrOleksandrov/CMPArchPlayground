package com.oleksandrov.cmp.arch.playground.epic.mapper

import com.oleksandrov.cmp.arch.playground.common.kotlin.CommonLocalDateFormat
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
        EpicUiModel(
            identifier = identifier,
            caption = caption,
            image = "https://api.nasa.gov/EPIC/archive/natural/${CommonLocalDateFormat.parseDate(date.orEmpty())}/thumbs/${image}.jpg?api_key=3SXKZBBq6vEmA7yamongiBY66cvnlx1JbeeDOtZu",
            date = date,
        )
    }
}