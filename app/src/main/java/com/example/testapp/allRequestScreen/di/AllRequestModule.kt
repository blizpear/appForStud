package com.example.testapp.allRequestScreen.di

import com.example.testapp.allRequestScreen.data.datasource.AllRequestDatasource
import com.example.testapp.allRequestScreen.data.datasource.AllRequestDatasourceImpl
import com.example.testapp.allRequestScreen.data.repository.AllRequestRepositoryImpl
import com.example.testapp.allRequestScreen.domain.AllRequestRepository
import com.example.testapp.allRequestScreen.domain.GetRequestsUsecase
import com.example.testapp.allRequestScreen.presentation.AllRequestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val allRequestModule = module {
	factory<AllRequestDatasource> { AllRequestDatasourceImpl(dao = get()) }

	factory<AllRequestRepository> { AllRequestRepositoryImpl(datasource = get()) }

	factory { GetRequestsUsecase(repository = get()) }

	viewModel {
		AllRequestViewModel(
			getRequestsUsecase = get(),
			router = get()
		)
	}
}