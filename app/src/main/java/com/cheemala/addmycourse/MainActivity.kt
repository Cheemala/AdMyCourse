package com.cheemala.addmycourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.cheemala.addmycourse.navigation.SetUpNavGraph
import com.cheemala.addmycourse.ui.theme.AddMyCourseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AddMyCourseTheme {

                val navController = rememberNavController()
                SetUpNavGraph(navController)

            }
        }
    }
}