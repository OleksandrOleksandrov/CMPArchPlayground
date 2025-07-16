package com.oleksandrov.cmp.arch.playground.data.epic.repository.impl

import com.oleksandrov.cmp.arch.playground.data.epic.model.EPICNetModel
import com.oleksandrov.cmp.arch.playground.data.epic.model.EPICRepoModel
import com.oleksandrov.cmp.arch.playground.data.epic.mapper.EPICRepoModelMapper
import com.oleksandrov.cmp.arch.playground.data.epic.repository.EPICRepository
import com.oleksandrov.cmp.arch.playground.data.epic.source.EPICNetSource
import io.ktor.client.call.body
import kotlinx.coroutines.flow.MutableStateFlow

class EPICRepositoryImpl(
    private val epicNetSource: EPICNetSource,
//    private val epicModelMapper: EPICRepoModelMapper, // TODO review
//    private val epicDbModelMapper: EPICDbModelMapper,
//    private val ePICDbRepoModelMapper: EPICDbRepoModelMapper,
//    private val dbSource: EPICDbDataSource,
) : EPICRepository {
    override val dataList: MutableStateFlow<List<EPICRepoModel>?> = MutableStateFlow(null)
//        dbSource.getFlow().withNullableListMapper(ePICDbRepoModelMapper)

    override suspend fun updateData() {
        dataList.value =
            epicNetSource.fetchEpic().body<List<EPICNetModel>>().map(EPICRepoModelMapper::mapTo)
    }

    override suspend fun fetchData(): List<EPICRepoModel>? {
        return epicNetSource.fetchEpic().body<List<EPICNetModel>>().map(EPICRepoModelMapper::mapTo)
    }
}