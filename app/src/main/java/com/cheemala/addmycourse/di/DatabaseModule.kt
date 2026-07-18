package com.cheemala.addmycourse.di

import android.content.Context
import androidx.room.Room
import com.cheemala.addmycourse.data.local.CourseDatabase
import com.cheemala.addmycourse.util.AppConstant.COURSE_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): CourseDatabase {
        return Room.databaseBuilder(
            context,
            CourseDatabase::class.java,
            COURSE_DATABASE
        ).build()
    }
}