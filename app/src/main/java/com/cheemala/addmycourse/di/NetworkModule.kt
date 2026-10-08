package com.cheemala.addmycourse.di

import com.cheemala.addmycourse.data.local.CourseDatabase
import com.cheemala.addmycourse.data.remote.network.CourseApiService
import com.cheemala.addmycourse.data.repositoryimpl.RemoteDataSourceImpl
import com.cheemala.addmycourse.domain.repository.RemoteDataSource
import com.cheemala.addmycourse.util.AppConstant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType())).build()
    }

    @Provides
    @Singleton
    fun provideCourseApiService(retrofit: Retrofit): CourseApiService {
        return retrofit.create(CourseApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(courseApiService: CourseApiService, courseDatabase: CourseDatabase) : RemoteDataSource {
        return RemoteDataSourceImpl(courseApiService, courseDatabase)
    }

}