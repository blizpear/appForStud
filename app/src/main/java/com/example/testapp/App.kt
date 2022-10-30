package com.example.testapp

import android.app.Application
import com.example.testapp.allRequestScreen.di.allRequestModule
import com.example.testapp.createRequestScreen.di.createRequestModule
import com.example.testapp.database.di.databaseModule
import com.example.testapp.di.globalNavigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

	override fun onCreate() {
		super.onCreate()

		//стартовая точка для Koin - здесь перечисляются все модули, что бы они знали друг о други и коин знал о них
		startKoin {
			androidContext(this@App)

			modules(
				globalNavigationModule,
				databaseModule,
				allRequestModule,
				createRequestModule
			)
		}
	}
}