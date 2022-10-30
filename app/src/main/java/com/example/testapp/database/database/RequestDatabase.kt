package com.example.testapp.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapp.database.dao.RequestDao
import com.example.testapp.database.entity.RequestEntity

@Database(
	entities = [
		RequestEntity::class
	],
	version = 1,
	exportSchema = false
)
abstract class RequestDatabase : RoomDatabase() {

	companion object {

		const val DATABASE_NAME = "request_db"
	}

	abstract fun requestDao(): RequestDao
}