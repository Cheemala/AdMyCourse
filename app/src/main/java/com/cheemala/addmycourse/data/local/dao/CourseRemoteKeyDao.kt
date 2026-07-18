package com.cheemala.addmycourse.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cheemala.addmycourse.domain.model.CourseRemoteKey

@Dao
interface CourseRemoteKeyDao {

    @Query("SELECT * FROM course_remote_key_table WHERE id=:id")
    fun getCourseRemoteKey(id: Int): CourseRemoteKey?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllCourseRemoteKeys(courseRemoteKeys: List<CourseRemoteKey>)

    @Query("DELETE FROM course_remote_key_table")
    suspend fun deleteAllCourseRemoteKeys()

}