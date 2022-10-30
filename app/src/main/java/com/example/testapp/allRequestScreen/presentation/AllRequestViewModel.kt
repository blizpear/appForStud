package com.example.testapp.allRequestScreen.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.testapp.allRequestScreen.domain.GetRequestsUsecase
import com.example.testapp.allRequestScreen.domain.Request
import com.example.testapp.createRequestScreen.getCreateRequestScreen
import com.example.testapp.navigation.getRootScreen
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class AllRequestViewModel(
	private val getRequestsUsecase: GetRequestsUsecase,
	private val router: Router
) : ViewModel() {

	val content: MutableLiveData<List<Request>> = MutableLiveData()

	init {
		//это корутины - многопоточка для работы с бд. Бд нельзя вызывать на основном потоке - корутины самый простой способ
		getRequestsUsecase()
			.onEach { newRequestsList ->
				content.postValue(newRequestsList)
			}.launchIn(viewModelScope)
	}

	fun navigateToAddScreen() {
		router.navigateTo(getCreateRequestScreen())
	}
}