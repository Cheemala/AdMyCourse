package com.cheemala.addmycourse.ui.theme

import android.provider.CalendarContract
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import kotlin.collections.copy

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Green500 = Color(0xFF8BC34A)

val ColorScheme.OnBoardingTextColor: Color
@Composable
get() = if(!isSystemInDarkTheme()) Color.Black else Color.LightGray

val ColorScheme.topAppBarContentColor: Color
@Composable
get() = if (!isSystemInDarkTheme()) Color.White else Color.LightGray

val ColorScheme.topAppBarBackgroundColor: Color
@Composable
get() = if (!isSystemInDarkTheme()) Green500 else Color.Black

val shimmerColors = listOf(
    Color(0xFFE0E0E0).copy(alpha = 0.9f), // Darker shade
    Color(0xFFF5F5F5).copy(alpha = 0.2f), // Highlight reflection
)

val ColorScheme.shimmerContentColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.White else Color.Black

val ColorScheme.shimmerColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color(0xFFE0E0E0).copy(alpha = 0.9f) else Color(0xFFE0E0E0).copy(alpha = 0.2f)

val ColorScheme.errorScreenBackgroundColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.White else Color.Black

val ColorScheme.errorTxtColor: Color
    @Composable
    get() = Color.Red.copy(alpha = 0.5f)

