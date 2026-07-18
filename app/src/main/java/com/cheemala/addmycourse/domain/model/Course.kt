package com.cheemala.addmycourse.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cheemala.addmycourse.util.AppConstant.COURSE_TABLE_NAME
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = COURSE_TABLE_NAME)
data class Course(
    @PrimaryKey(autoGenerate = false)
    val course_id: Int,
    val course_name: String,
    val description: String,
    val authors: List<String>,
    val banner_img: String,
    val course_content: List<CourseContent>,
    val last_modified: String,
    val launch_date: String,
    val level: String,
    val no_of_students_enrolled: Int,
    val rating: Double
)

@Serializable
data class CourseContent(
    val lessons: List<String>,
    val module_name: String
)