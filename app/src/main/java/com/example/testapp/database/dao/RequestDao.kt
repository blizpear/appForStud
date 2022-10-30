package com.example.testapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testapp.database.entity.RequestEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RequestDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertRequest(request: RequestEntity)

	@Query("SELECT * FROM request_table")
	fun getAllRequest(): Flow<List<RequestEntity>>
}