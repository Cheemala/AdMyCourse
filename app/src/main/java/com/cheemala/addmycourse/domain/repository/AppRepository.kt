package com.cheemala.addmycourse.domain.repository

import androidx.paging.PagingData
import com.cheemala.addmycourse.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    fun readOnBoardingState(): Flow<Boolean>

    suspend fun saveOnBoardingState(completed: Boolean)

    fun getAllCourses(): Flow<PagingData<Course>>

}