package com.cheemala.addmycourse.data.remote.network

import com.cheemala.addmycourse.data.remote.CourseApiResponse
import com.cheemala.addmycourse.domain.model.Course
import retrofit2.http.GET
import retrofit2.http.Query


interface CourseApiService {

    @GET("/cheemala/getAllCourses")
    suspend fun getAllCourses(@Query("page") page: Int = 1): CourseApiResponse

    @GET("/cheemala/searchCourses")
    suspend fun searchCourses(@Query("name") name: String): CourseApiResponse

}