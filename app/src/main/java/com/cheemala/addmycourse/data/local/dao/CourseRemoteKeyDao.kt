package com.cheemala.addmycourse.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cheemala.addmycourse.domain.model.CourseRemoteKeys

@Dao
interface CourseRemoteKeyDao {

    @Query("SELECT * FROM course_remote_key_table WHERE id=:id")
    suspend fun getCourseRemoteKey(id: Int): CourseRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllCourseRemoteKeys(courseRemoteKeys: List<CourseRemoteKeys>)

    @Query("DELETE FROM course_remote_key_table")
    suspend fun deleteAllCourseRemoteKeys()

}