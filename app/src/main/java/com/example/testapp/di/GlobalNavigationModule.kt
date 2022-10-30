package com.example.testapp.di

import com.example.testapp.navigation.provideCicerone
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.dsl.module

//модуль для di который будет создавать наши классы
//single - класс существует в едином экземпляре когда бы мы к нему не обратились

val globalNavigationModule = module {

	single { provideCicerone() }
	single { get<Cicerone<Router>>().router }
	single { get<Cicerone<Router>>().getNavigatorHolder() }
}