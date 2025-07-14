package com.oleksandrov.cmp.arch.playground.data.epic.mapper

import com.oleksandrov.cmp.arch.playground.common.mapper.BaseMapper
import com.oleksandrov.cmp.arch.playground.data.epic.model.EPICNetModel
import com.oleksandrov.cmp.arch.playground.data.epic.model.EPICRepoModel

object EPICRepoModelMapper : BaseMapper<EPICNetModel, EPICRepoModel> {
    override fun mapTo(model: EPICNetModel) = with(model) {
        EPICRepoModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }

    override fun mapFrom(model: EPICRepoModel) = with(model) {
        EPICNetModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }
}