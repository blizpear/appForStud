package com.example.testapp.database.di

import androidx.room.Room
import com.example.testapp.database.database.RequestDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

	factory { get<RequestDatabase>().requestDao() }

	single {
		Room.databaseBuilder(
			androidContext(),
			RequestDatabase::class.java,
			RequestDatabase.DATABASE_NAME
		).build()
	}
}