package com.example.testapp.allRequestScreen.data.datasource

import com.example.testapp.database.entity.RequestEntity
import kotlinx.coroutines.flow.Flow

interface AllRequestDatasource {

	fun getAllRequests(): Flow<List<RequestEntity>>
}