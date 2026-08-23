package com.cheemala.addmycourse.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.cheemala.addmycourse.data.repositoryimpl.DatastoreRepositoryImpl
import com.cheemala.addmycourse.domain.repository.DatastoreRepository
import com.cheemala.addmycourse.domain.use_cases.DatastoreUsecases
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
    fun provideDatastoreRepository(datastore: DataStore<Preferences>): DatastoreRepository {
        return DatastoreRepositoryImpl(datastore)
    }

    @Provides
    @Singleton
    fun provideDatastoreUseCases(datastoreRepository: DatastoreRepository): DatastoreUsecases {
        return DatastoreUsecases(
            readOnboardingState = ReadOnboardingStateUsecase(
                datastoreRepository = datastoreRepository
            ),
            saveOnboardingStateUsecase = SaveOnboardingStateUsecase(datastoreRepository = datastoreRepository)
        )
    }

}