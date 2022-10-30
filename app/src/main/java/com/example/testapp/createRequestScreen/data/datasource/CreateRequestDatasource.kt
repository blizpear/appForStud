package com.example.testapp.createRequestScreen.data.datasource

import com.example.testapp.database.entity.RequestEntity

interface CreateRequestDatasource {

	suspend fun saveRequest(request: RequestEntity)
}