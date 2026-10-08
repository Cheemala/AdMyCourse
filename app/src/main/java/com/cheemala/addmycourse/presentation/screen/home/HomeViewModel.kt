package com.cheemala.addmycourse.presentation.screen.home

import androidx.lifecycle.ViewModel
import com.cheemala.addmycourse.domain.use_cases.AppUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val appUsecases: AppUsecases): ViewModel() {

    val allCourses = appUsecases.getAllCoursesUseCase()

}