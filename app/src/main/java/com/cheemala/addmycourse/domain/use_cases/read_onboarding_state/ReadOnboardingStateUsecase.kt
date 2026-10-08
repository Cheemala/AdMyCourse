package com.cheemala.addmycourse.domain.use_cases.read_onboarding_state

import com.cheemala.addmycourse.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadOnboardingStateUsecase @Inject constructor(private val appRepository: AppRepository)  {
    operator fun invoke(): Flow<Boolean> {
        return appRepository.readOnBoardingState()
    }
}