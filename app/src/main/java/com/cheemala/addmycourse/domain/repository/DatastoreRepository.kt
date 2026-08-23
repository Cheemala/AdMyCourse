package com.cheemala.addmycourse.domain.repository

import kotlinx.coroutines.flow.Flow

interface DatastoreRepository {

    fun readOnBoardingState(): Flow<Boolean>

    suspend fun saveOnBoardingState(completed: Boolean)

}