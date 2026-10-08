package com.cheemala.addmycourse.domain.repository

import androidx.paging.PagingData
import com.cheemala.addmycourse.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllCourses(): Flow<PagingData<Course>>

    fun searchCourses(name: String): Flow<PagingData<Course>>

}