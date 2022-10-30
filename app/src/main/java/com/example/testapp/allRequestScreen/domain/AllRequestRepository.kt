package com.example.testapp.allRequestScreen.domain

import kotlinx.coroutines.flow.Flow

interface AllRequestRepository {

	fun getAllRequests(): Flow<List<Request>>
}