package com.example.testapp.createRequestScreen.data.repository

import com.example.testapp.createRequestScreen.data.datasource.CreateRequestDatasource
import com.example.testapp.createRequestScreen.data.mappers.toDb
import com.example.testapp.createRequestScreen.domain.CreateRequestRepository
import com.example.testapp.createRequestScreen.domain.Request

class CreateRequestRepositoryImpl(
	val datasource: CreateRequestDatasource
) : CreateRequestRepository {

	override suspend fun saveRequest(request: Request) = datasource.saveRequest(request = request.toDb())
}