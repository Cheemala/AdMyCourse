package com.cheemala.addmycourse.presentation.screen.welcome

import androidx.annotation.DrawableRes
import com.cheemala.addmycourse.R

sealed class OnBoardingScreen(
    @DrawableRes
    val onBoardingIcon: Int,
    val title: String,
    val description: String
) {
    object FirstOnboardingPage : OnBoardingScreen(onBoardingIcon = R.drawable.welcome, title = "Welcome", description = "Welcome to the India's No.1 EdTech platform. User Friendly, Feel Good Courses at affordable prices!")
    object SecondOnboardingPage : OnBoardingScreen(onBoardingIcon = R.drawable.explore, title = "Explore", description = "Explore as many as courses across multiple streams at the best of Industry cost")
    object ThirdOnboardingPage : OnBoardingScreen(onBoardingIcon = R.drawable.learn, title = "Learn", description = "Learn courses at your own pace, Lifetime Access through Online, No CC Required, 100% Money Guaranty & Get Course Completion Certificates")
}