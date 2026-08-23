package com.cheemala.addmycourse.presentation.screen.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.cheemala.addmycourse.R
import com.cheemala.addmycourse.navigation.Screen

@Composable
fun SplashScreen(
    splashScreenViewModel: SplashScreenViewModel = hiltViewModel(),
    navController: NavController
) {

    Splash(splashScreenViewModel, navController)

}

@Composable
fun Splash(splashScreenViewModel: SplashScreenViewModel, navController: NavController) {

    val isOnBoardingCompleted by splashScreenViewModel.onBoardingCompletedState.collectAsState()
    val rotateAnim = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        rotateAnim.animateTo(
            targetValue = 360f, animationSpec = tween(
                durationMillis = 2000, easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )

        if (!isOnBoardingCompleted) {
            navController.popBackStack()
            navController.navigate(Screen.WelcomeScreen.route)
        } else {
            navController.popBackStack()
            navController.navigate(Screen.HomeScreen.route)
        }
    }

    if (!isSystemInDarkTheme()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            colorResource(R.color.green_700), colorResource(R.color.green_500)
                        )
                    )
                ),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painterResource(R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(100.dp)
                    .rotate(rotateAnim.value)
            )
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            colorResource(R.color.black), colorResource(R.color.black)
                        )
                    )
                ),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painterResource(R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(100.dp)
                    .rotate(rotateAnim.value)
            )
        }
    }

}