package com.cheemala.addmycourse.presentation.screen.welcome

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.cheemala.addmycourse.R
import com.cheemala.addmycourse.navigation.Screen
import com.cheemala.addmycourse.util.GlobalComposables.CommonButton
import com.cheemala.addmycourse.util.GlobalComposables.CommonTextView

@Composable
fun WelcomeScreen(welcomeScreenViewModel: WelcomeScreenViewModel = hiltViewModel(), navController: NavController) {

    val onBoaardingPageList = listOf(OnBoardingScreen.FirstOnboardingPage, OnBoardingScreen.SecondOnboardingPage,
        OnBoardingScreen.ThirdOnboardingPage)

    val pagerState = rememberPagerState(pageCount = {
        onBoaardingPageList.size
    })

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(modifier = Modifier.weight(8f), state = pagerState, verticalAlignment = Alignment.Top) { pagePosition ->
            PageContent(onBoardingScreen = onBoaardingPageList[pagePosition])
        }

        Row(
            Modifier
                .weight(1f)
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) colorResource(R.color.orange_700) else colorResource(R.color.orange_200)
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)
                )
            }
        }

        Row(modifier = Modifier.padding(horizontal = 40.dp).weight(1f).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            AnimatedVisibility(modifier = Modifier.fillMaxWidth(), visible = pagerState.currentPage == pagerState.pageCount-1) {
                CommonButton(text = "Next", color = R.color.orange_700, textColor = R.color.white) {
                    Log.d("on_boarding_completed_","true")
                    welcomeScreenViewModel.saveOnBoardingState(true)
                    navController.popBackStack()
                    navController.navigate(Screen.HomeScreen.route)
                }
            }
        }
    }
}

@Composable
fun PageContent(onBoardingScreen: OnBoardingScreen) {
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Image(modifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.7f),painter = painterResource(onBoardingScreen.onBoardingIcon), contentDescription = "Welcome Screen")
        Spacer(modifier = Modifier.height(2.dp))
        // Title TextView
        CommonTextView(text = onBoardingScreen.title, fontSize = 32.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif)
        Spacer(modifier = Modifier.height(2.dp))
        // Description TextView
        CommonTextView(text = onBoardingScreen.description, fontSize = 18.sp, fontWeight = FontWeight.Normal, fontFamily = FontFamily.SansSerif, maxLines = 3)
    }
}

@Preview(showBackground = true)
@Composable
fun ExistOnBoardingBtn(){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        CommonButton(modifier = Modifier.fillMaxWidth(0.5f), text = "Next", color = R.color.orange_700, textColor = R.color.white) {}
    }
}