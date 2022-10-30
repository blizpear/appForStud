package com.example.testapp.createRequestScreen.domain

interface CreateRequestRepository {

	suspend fun saveRequest(request: Request)
}