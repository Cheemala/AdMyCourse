package com.cheemala.addmycourse.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cheemala.addmycourse.util.AppConstant.COURSE_REMOTE_KEY_TABLE_NAME

@Entity(tableName = COURSE_REMOTE_KEY_TABLE_NAME)
data class CourseRemoteKey(
    @PrimaryKey(autoGenerate = false) val id: Int, val prevPage: Int?, val nextPage: Int?
)
