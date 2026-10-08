package com.cheemala.addmycourse.presentation.screen.home

import androidx.annotation.DrawableRes
import com.cheemala.addmycourse.R

sealed class ErrorScreenComponents(
    @DrawableRes
    val errorImg: Int,
    val errorDescription: String,
) {

    object NoInternetError :
        ErrorScreenComponents(errorImg = R.drawable.no_internet, errorDescription = "No Internet Connection")

    object ServerError :
        ErrorScreenComponents(errorImg = R.drawable.server_error, errorDescription = "Server Error")

    object UnknownError :
        ErrorScreenComponents(errorImg = R.drawable.unknown_error, errorDescription = "Unknown Error")

}