package com.cheemala.addmycourse.presentation.screen.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.cheemala.addmycourse.R
import com.cheemala.addmycourse.ui.theme.topAppBarBackgroundColor
import com.cheemala.addmycourse.ui.theme.topAppBarContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(onSearchClicked: () -> Unit) {

    TopAppBar(
        title = {
            Text(text = stringResource(R.string.explore_courses_name), color = MaterialTheme.colorScheme.topAppBarContentColor)
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
            titleContentColor = MaterialTheme.colorScheme.topAppBarContentColor,
            navigationIconContentColor = MaterialTheme.colorScheme.topAppBarContentColor,
            actionIconContentColor = MaterialTheme.colorScheme.topAppBarContentColor
        ), actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_search),
                    contentDescription = "Search Icon",
                    tint = MaterialTheme.colorScheme.topAppBarContentColor
                )
            }
        })

}