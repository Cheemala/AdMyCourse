package com.cheemala.addmycourse.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cheemala.addmycourse.data.DatabaseTypeConverter
import com.cheemala.addmycourse.data.local.dao.CourseDao
import com.cheemala.addmycourse.data.local.dao.CourseRemoteKeyDao
import com.cheemala.addmycourse.domain.model.Course
import com.cheemala.addmycourse.domain.model.CourseRemoteKey

@Database(entities = [Course::class, CourseRemoteKey::class], version = 1)
@TypeConverters(DatabaseTypeConverter::class)
abstract class CourseDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
    abstract fun CourseRemoteKeyDao(): CourseRemoteKeyDao
}