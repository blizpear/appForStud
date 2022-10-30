package com.example.testapp.createRequestScreen.di

import com.example.testapp.createRequestScreen.data.datasource.CreateRequestDatasource
import com.example.testapp.createRequestScreen.data.datasource.CreateRequestDatasourceImpl
import com.example.testapp.createRequestScreen.data.repository.CreateRequestRepositoryImpl
import com.example.testapp.createRequestScreen.domain.CreateRequestRepository
import com.example.testapp.createRequestScreen.domain.SaveRequestUsecase
import com.example.testapp.createRequestScreen.presentation.CreateRequestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val createRequestModule = module {
	factory<CreateRequestDatasource> { CreateRequestDatasourceImpl(dao = get()) }

	factory<CreateRequestRepository> { CreateRequestRepositoryImpl(datasource = get()) }

	factory { SaveRequestUsecase(repository = get()) }

	viewModel {
		CreateRequestViewModel(
			saveRequestUsecase = get(),
			router = get()
		)
	}
}