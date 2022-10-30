package com.example.testapp.createRequestScreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.createRequestScreen.domain.Request
import com.example.testapp.createRequestScreen.domain.SaveRequestUsecase
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.launch

class CreateRequestViewModel(
	private val saveRequestUsecase: SaveRequestUsecase,
	private val router: Router
) : ViewModel() {

	fun saveRequest(name: String, date: String, reason: String) {
		viewModelScope.launch {
			saveToDb(Request(name, date, reason))
		}
		router.exit()
	}

	//join ждет результат выполнения асинхронного кода
	private suspend fun saveToDb(request: Request) {
		viewModelScope.launch {
			saveRequestUsecase(request)
		}.join()
	}
}