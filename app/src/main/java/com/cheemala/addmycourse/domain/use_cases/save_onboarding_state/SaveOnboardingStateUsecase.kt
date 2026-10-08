package com.cheemala.addmycourse.domain.use_cases.save_onboarding_state

import com.cheemala.addmycourse.domain.repository.AppRepository
import javax.inject.Inject

class SaveOnboardingStateUsecase @Inject constructor(private val appRepository: AppRepository) {
    suspend operator fun invoke(completed: Boolean) {
        appRepository.saveOnBoardingState(completed)
    }
}