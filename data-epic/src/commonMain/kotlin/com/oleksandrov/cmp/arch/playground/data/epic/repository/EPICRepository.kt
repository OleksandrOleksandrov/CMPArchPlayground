package com.oleksandrov.cmp.arch.playground.data.epic.repository

import com.oleksandrov.cmp.arch.playground.data.epic.model.EPICRepoModel
import kotlinx.coroutines.flow.Flow

interface EPICRepository {
    val dataList: Flow<List<EPICRepoModel>?>

    suspend fun updateData()
}