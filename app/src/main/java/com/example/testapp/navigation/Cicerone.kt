package com.example.testapp.navigation

import com.github.terrakok.cicerone.Cicerone

//создаем навигацию и указываем какой фрагмент запускается первым
fun provideCicerone() = Cicerone.create().apply {
	router.newRootScreen(getRootScreen())
}