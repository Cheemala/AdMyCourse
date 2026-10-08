package com.cheemala.addmycourse.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.cheemala.addmycourse.data.repositoryimpl.AppRepositoryImpl
import com.cheemala.addmycourse.domain.repository.AppRepository
import com.cheemala.addmycourse.domain.repository.RemoteDataSource
import com.cheemala.addmycourse.domain.use_cases.AppUsecases
import com.cheemala.addmycourse.domain.use_cases.get_all_courses.GetAllCoursesUseCase
import com.cheemala.addmycourse.domain.use_cases.read_onboarding_state.ReadOnboardingStateUsecase
import com.cheemala.addmycourse.domain.use_cases.save_onboarding_state.SaveOnboardingStateUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDatastoreRepository(
        datastore: DataStore<Preferences>,
        remoteDataSource: RemoteDataSource
    ): AppRepository {
        return AppRepositoryImpl(datastore, remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideDatastoreUseCases(appRepository: AppRepository): AppUsecases {
        return AppUsecases(
            readOnboardingState = ReadOnboardingStateUsecase(
                appRepository = appRepository
            ),
            saveOnboardingStateUsecase = SaveOnboardingStateUsecase(appRepository = appRepository),
            getAllCoursesUseCase = GetAllCoursesUseCase(appRepository = appRepository)
        )
    }

}