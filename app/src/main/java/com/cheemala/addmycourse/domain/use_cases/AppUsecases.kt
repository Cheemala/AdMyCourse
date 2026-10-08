package com.cheemala.addmycourse.domain.use_cases

import com.cheemala.addmycourse.domain.use_cases.get_all_courses.GetAllCoursesUseCase
import com.cheemala.addmycourse.domain.use_cases.read_onboarding_state.ReadOnboardingStateUsecase
import com.cheemala.addmycourse.domain.use_cases.save_onboarding_state.SaveOnboardingStateUsecase

data class AppUsecases(
    val readOnboardingState: ReadOnboardingStateUsecase,
    val saveOnboardingStateUsecase: SaveOnboardingStateUsecase,
    val getAllCoursesUseCase: GetAllCoursesUseCase
)
