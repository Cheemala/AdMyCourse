package com.cheemala.addmycourse.data.repositoryimpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.paging.PagingData
import com.cheemala.addmycourse.domain.model.Course
import com.cheemala.addmycourse.domain.repository.AppRepository
import com.cheemala.addmycourse.domain.repository.RemoteDataSource
import com.cheemala.addmycourse.util.AppConstant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(private val datastore: DataStore<Preferences>,
    private val remoteDataSource: RemoteDataSource
) : AppRepository {
    override fun readOnBoardingState(): Flow<Boolean> {
        return datastore.data.map { prefs ->
            prefs[AppConstant.APP_PREFS_ONBOARDING_KEY]?:false
        }
    }

    override suspend fun saveOnBoardingState(completed: Boolean) {
        datastore.edit { prefs ->
            prefs[AppConstant.APP_PREFS_ONBOARDING_KEY] = completed
        }
    }

    override fun getAllCourses(): Flow<PagingData<Course>> {
        return remoteDataSource.getAllCourses()
    }

}