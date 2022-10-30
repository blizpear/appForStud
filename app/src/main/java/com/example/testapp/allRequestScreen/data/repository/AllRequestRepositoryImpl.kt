package com.example.testapp.allRequestScreen.data.repository

import com.example.testapp.allRequestScreen.data.datasource.AllRequestDatasource
import com.example.testapp.allRequestScreen.data.mapper.toDomainListFlow
import com.example.testapp.allRequestScreen.domain.AllRequestRepository
import com.example.testapp.allRequestScreen.domain.Request
import kotlinx.coroutines.flow.Flow

class AllRequestRepositoryImpl(
	private val datasource: AllRequestDatasource
) : AllRequestRepository {

	override fun getAllRequests(): Flow<List<Request>> = datasource.getAllRequests().toDomainListFlow()
}