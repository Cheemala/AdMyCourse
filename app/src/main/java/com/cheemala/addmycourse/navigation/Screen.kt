package com.cheemala.addmycourse.navigation

import com.cheemala.addmycourse.util.AppConstant.COURSE_DETAIL_ARGUMENT_KEY

sealed class Screen(val route: String) {

    object SplashScreen : Screen("splash_screen")
    object WelcomeScreen : Screen("welcome_screen")
    object HomeScreen : Screen("home_screen")
    object CourseDetailScreen : Screen("course_details_screen/$COURSE_DETAIL_ARGUMENT_KEY"){
        fun passCourseId(courseId: Int): String {
            return "course_details_screen/$courseId"
        }
    }
    object SearchScreen : Screen("search_screen")
}