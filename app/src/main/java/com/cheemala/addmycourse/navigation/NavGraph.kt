package com.cheemala.addmycourse.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cheemala.addmycourse.screen.CourseDetailScreen
import com.cheemala.addmycourse.screen.HomeScreen
import com.cheemala.addmycourse.screen.SearchScreen
import com.cheemala.addmycourse.screen.SplashScreen
import com.cheemala.addmycourse.screen.WelcomeScreen

@Composable
fun SetUpNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {

        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.WelcomeScreen.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.CourseDetailScreen.route) {
            CourseDetailScreen(navController = navController)
        }
        composable(route = Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }

    }

}
