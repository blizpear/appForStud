package com.example.testapp.allRequestScreen.data.mapper

import com.example.testapp.allRequestScreen.domain.Request
import com.example.testapp.database.entity.RequestEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun RequestEntity.toDomain() =
	Request(
		id = id,
		name = name,
		date = date,
		reason = reason
	)

fun List<RequestEntity>.toDomainList() = map(RequestEntity::toDomain)

fun Flow<List<RequestEntity>>.toDomainListFlow() = map(List<RequestEntity>::toDomainList)