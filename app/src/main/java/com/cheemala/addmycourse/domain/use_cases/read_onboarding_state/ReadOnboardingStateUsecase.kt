package com.cheemala.addmycourse.domain.use_cases.read_onboarding_state

import com.cheemala.addmycourse.domain.repository.DatastoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadOnboardingStateUsecase @Inject constructor(private val datastoreRepository: DatastoreRepository)  {
    operator fun invoke(): Flow<Boolean> {
        return datastoreRepository.readOnBoardingState()
    }
}