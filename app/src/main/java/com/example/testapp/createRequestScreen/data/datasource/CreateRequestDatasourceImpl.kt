package com.example.testapp.createRequestScreen.data.datasource

import com.example.testapp.database.dao.RequestDao
import com.example.testapp.database.entity.RequestEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CreateRequestDatasourceImpl(
	private val dao: RequestDao
) : CreateRequestDatasource {

	override suspend fun saveRequest(request: RequestEntity) = withContext(Dispatchers.IO) { dao.insertRequest(request) }
}