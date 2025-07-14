package com.oleksandrov.cmp.arch.playground.domain.epic.mapper

import com.oleksandrov.cmp.arch.playground.common.mapper.BaseMapper
import com.oleksandrov.cmp.arch.playground.data.epic.model.EPICRepoModel
import com.oleksandrov.cmp.arch.playground.domain.epic.model.EPICDomainModel

object EPICDomainRepoModelMapper : BaseMapper<EPICDomainModel, EPICRepoModel> {
    override fun mapTo(model: EPICDomainModel) = with(model) {
        EPICRepoModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }

    override fun mapFrom(model: EPICRepoModel) = with(model) {
        EPICDomainModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }
}