package com.cheemala.addmycourse.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(topBar = {TopAppBar (onSearchClicked = {})}) { contentPadding ->

        Box(modifier = Modifier.padding(contentPadding)) { }

    }

}