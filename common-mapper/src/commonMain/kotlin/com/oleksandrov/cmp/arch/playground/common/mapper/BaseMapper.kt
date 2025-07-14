package com.oleksandrov.cmp.arch.playground.common.mapper

interface BaseMapper<In : Any, Out : Any> {
    fun mapTo(model: In): Out =
        throw NotImplementedError("${this::class} function mapTo function for class ${model::class} is not implemented") // TODO check is this correct? this::class.java

    fun mapFrom(model: Out): In =
        throw NotImplementedError("${this::class} function mapFrom function for class ${model::class} is not implemented") // TODO check is this correct? this::class.java

    fun mapListTo(model: List<In>): List<Out> = model.map { mapTo(it) }
    fun mapListFrom(model: List<Out>): List<In> = model.map { mapFrom(it) }
}