package com.oleksandrov.cmp.arch.playground.domain.epic.mapper

import com.oleksandrov.cmp.arch.playground.common.kotlin.date.createDateTimeFormatWith
import com.oleksandrov.cmp.arch.playground.common.kotlin.extension.PATTERN_DATE_SLASHED_DIGITS_FULL_FORMAT
import com.oleksandrov.cmp.arch.playground.common.kotlin.extension.parseToLocalDateWith
import com.oleksandrov.cmp.arch.playground.common.mapper.BaseMapper
import com.oleksandrov.cmp.arch.playground.domain.epic.model.EPICDomainModel
import com.oleksandrov.cmp.arch.playground.presentation.core.model.EpicUiModel
import kotlinx.datetime.format
import kotlinx.datetime.format.FormatStringsInDatetimeFormats

object EPICDomainUiModelMapper : BaseMapper<EPICDomainModel, EpicUiModel> {
    override fun mapFrom(model: EpicUiModel) = with(model) {
        EPICDomainModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }

    @OptIn(FormatStringsInDatetimeFormats::class)
    override fun mapTo(model: EPICDomainModel) = with(model) {
        val format = createDateTimeFormatWith(PATTERN_DATE_SLASHED_DIGITS_FULL_FORMAT)
        EpicUiModel(
            identifier = identifier,
            caption = caption,
            image = date?.let {
                "https://epic.gsfc.nasa.gov/archive/natural/${
                    it.parseToLocalDateWith().format(format)
                }/thumbs/${image}.jpg?api_key=3SXKZBBq6vEmA7yamongiBY66cvnlx1JbeeDOtZu"
            },
            date = date,
        )
    }
}
