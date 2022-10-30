package com.example.testapp.createRequestScreen.domain

class SaveRequestUsecase(
	private val repository: CreateRequestRepository
) {

	suspend operator fun invoke(request: Request) = repository.saveRequest(request)
}