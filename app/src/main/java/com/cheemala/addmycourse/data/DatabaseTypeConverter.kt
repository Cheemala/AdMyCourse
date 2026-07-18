package com.cheemala.addmycourse.data

import androidx.room.TypeConverter
import com.cheemala.addmycourse.domain.model.CourseContent
import kotlinx.serialization.json.Json

class DatabaseTypeConverter {

    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromCourseContentList(value: List<CourseContent>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toCourseContentList(value: String): List<CourseContent> {
        return Json.decodeFromString(value)
    }
}