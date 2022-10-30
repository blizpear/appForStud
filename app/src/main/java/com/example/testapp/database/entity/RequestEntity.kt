package com.example.testapp.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
	tableName = "request_table"
)
data class RequestEntity(
	val name: String,
	val date: String,
	val reason: String
){
	@PrimaryKey(autoGenerate = true)
	var id: Int = 0
}
