package com.cheemala.addmycourse.data.repositoryimpl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.cheemala.addmycourse.data.local.CourseDatabase
import com.cheemala.addmycourse.data.local.dao.CourseDao
import com.cheemala.addmycourse.data.pagingsource.CourseRemoteMediator
import com.cheemala.addmycourse.data.remote.network.CourseApiService
import com.cheemala.addmycourse.domain.model.Course
import com.cheemala.addmycourse.domain.repository.RemoteDataSource
import com.cheemala.addmycourse.util.AppConstant.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val courseApiService: CourseApiService, private val courseDatabase: CourseDatabase) : RemoteDataSource  {

    private val courseDao = courseDatabase.courseDao()

    @OptIn(ExperimentalPagingApi::class)
    override fun getAllCourses(): Flow<PagingData<Course>> {
        val pagingSourceFactory = { courseDao.getAllCourses() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = CourseRemoteMediator(
                courseApiService = courseApiService,
                courseDatabase = courseDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchCourses(name: String): Flow<PagingData<Course>> {
        TODO("Not yet implemented")
    }

}