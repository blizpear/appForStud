package com.example.testapp.createRequestScreen.data.mappers

import com.example.testapp.createRequestScreen.domain.Request
import com.example.testapp.database.entity.RequestEntity

fun Request.toDb() =
	RequestEntity(
		name = name,
		date = date,
		reason = reason
	)