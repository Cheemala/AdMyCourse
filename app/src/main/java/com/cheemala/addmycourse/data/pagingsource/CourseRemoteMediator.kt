package com.cheemala.addmycourse.data.pagingsource

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.cheemala.addmycourse.data.local.CourseDatabase
import com.cheemala.addmycourse.data.remote.network.CourseApiService
import com.cheemala.addmycourse.domain.model.Course
import com.cheemala.addmycourse.domain.model.CourseRemoteKeys

@OptIn(ExperimentalPagingApi::class)
class CourseRemoteMediator(
    private val courseApiService: CourseApiService, private val courseDatabase: CourseDatabase
) : RemoteMediator<Int, Course>() {
    private val courseDao = courseDatabase.courseDao()
    private val courseRemoteKeys = courseDatabase.CourseRemoteKeyDao()

    override suspend fun initialize(): InitializeAction {
        val isCourseDataExpired = validateIfCourseDataExpired()
        return if (isCourseDataExpired) {
            Log.d("course_response_", "data expired")
            InitializeAction.LAUNCH_INITIAL_REFRESH
        } else {
            Log.d("course_response_", "data not expired")
            InitializeAction.SKIP_INITIAL_REFRESH
        }
    }

    private suspend fun validateIfCourseDataExpired(): Boolean {
        val currentTimeInMillis = System.currentTimeMillis()
        val lastUpdatedTimeInMillis = courseRemoteKeys.getCourseRemoteKey(id = 1001)?.lastUpdated ?: 0L
        val expiredTimeInMin = 5
        return (currentTimeInMillis - lastUpdatedTimeInMillis) > (expiredTimeInMin * 60 * 1000)
    }

    override suspend fun load(
        loadType: LoadType, state: PagingState<Int, Course>
    ): MediatorResult {


        return try {

            val page = when (loadType) {
                LoadType.REFRESH -> {

                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1

                }

                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    prevPage
                }

                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    nextPage
                }
            }

            val response = courseApiService.getAllCourses(page = page)
            Log.d("course_response_", response.toString())
            if (response.courses.isNotEmpty()) {

                courseDatabase.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        courseDao.deleteAllCourses()
                        courseRemoteKeys.deleteAllCourseRemoteKeys()
                    }
                    val prevPage = response.prevPage
                    val nextPage = response.nextPage
                    val keys = response.courses.map { course ->
                        CourseRemoteKeys(
                            id = course.course_id,
                            prevPage = prevPage,
                            nextPage = nextPage,
                            lastUpdated = response.lastUpdated
                        )
                    }
                    courseRemoteKeys.addAllCourseRemoteKeys(courseRemoteKeys = keys)
                    courseDao.insertCourses(response.courses)
                }
            }
            MediatorResult.Success(endOfPaginationReached = response.nextPage == null)
        } catch (e: Exception) {
            Log.d("course_error_", e.toString())
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, Course>): CourseRemoteKeys? {
        return state.anchorPosition?.let {
            state.closestItemToPosition(it)?.course_id?.let { id ->
                courseRemoteKeys.getCourseRemoteKey(id = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, Course>): CourseRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { course ->
                courseRemoteKeys.getCourseRemoteKey(id = course.course_id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, Course>): CourseRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { course ->
                courseRemoteKeys.getCourseRemoteKey(id = course.course_id)
            }
    }


}