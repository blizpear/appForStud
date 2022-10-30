package com.example.testapp.allRequestScreen.domain

class GetRequestsUsecase(
	private val repository: AllRequestRepository
) {

	operator fun invoke() = repository.getAllRequests()
}