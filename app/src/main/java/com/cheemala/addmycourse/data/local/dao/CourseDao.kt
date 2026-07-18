package com.cheemala.addmycourse.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cheemala.addmycourse.domain.model.Course

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourses(course: List<Course>)

    @Query("SELECT * FROM course_table ORDER BY course_id ASC")
    fun getAllCourses(): PagingSource<Int, Course>

    @Query("SELECT * FROM course_table WHERE course_id=:courseId")
    fun getCourseById(courseId: Int): Course

    @Query("DELETE FROM course_table")
    suspend fun deleteAllCourses()

}