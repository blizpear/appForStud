package com.example.testapp.allRequestScreen.data.datasource

import com.example.testapp.database.dao.RequestDao
import com.example.testapp.database.entity.RequestEntity
import kotlinx.coroutines.flow.Flow

class AllRequestDatasourceImpl(
	val dao: RequestDao
) : AllRequestDatasource {

	override fun getAllRequests(): Flow<List<RequestEntity>> = dao.getAllRequest()
}