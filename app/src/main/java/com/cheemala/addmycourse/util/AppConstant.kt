package com.cheemala.addmycourse.util

import androidx.datastore.preferences.core.booleanPreferencesKey

object AppConstant {
    const val COURSE_DETAIL_ARGUMENT_KEY = "courseId"

    const val BASE_URL = "http://10.0.2.2:8080/"

    const val COURSE_DATABASE = "course_database"
    const val COURSE_TABLE_NAME = "course_table"
    const val COURSE_REMOTE_KEY_TABLE_NAME = "course_remote_key_table"

    const val APP_PREFS_NAME = "ad_my_course_prefs"

    const val ITEMS_PER_PAGE = 3

    val APP_PREFS_ONBOARDING_KEY = booleanPreferencesKey("onboarding_completed")

}