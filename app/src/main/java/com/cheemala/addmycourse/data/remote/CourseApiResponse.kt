package com.cheemala.addmycourse.data.remote

import com.cheemala.addmycourse.domain.model.Course
import kotlinx.serialization.Serializable

@Serializable
data class CourseApiResponse(
    val status: Boolean,
    val message: String,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val lastUpdated: Long? = null,
    val courses: List<Course> = emptyList())

