package com.cheemala.addmycourse.domain.use_cases.get_all_courses

import com.cheemala.addmycourse.domain.repository.AppRepository
import javax.inject.Inject

class GetAllCoursesUseCase @Inject constructor(private val appRepository: AppRepository) {
    operator fun invoke() = appRepository.getAllCourses()
}