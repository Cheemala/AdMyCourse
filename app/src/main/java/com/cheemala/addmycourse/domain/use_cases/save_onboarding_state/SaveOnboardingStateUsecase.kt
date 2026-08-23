package com.cheemala.addmycourse.domain.use_cases.save_onboarding_state

import com.cheemala.addmycourse.domain.repository.DatastoreRepository
import javax.inject.Inject

class SaveOnboardingStateUsecase @Inject constructor(private val datastoreRepository: DatastoreRepository) {
    suspend operator fun invoke(completed: Boolean) {
        datastoreRepository.saveOnBoardingState(completed)
    }
}