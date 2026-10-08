package com.cheemala.addmycourse.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.cheemala.addmycourse.component.ShimmerEffect
import com.cheemala.addmycourse.domain.model.Course
import com.cheemala.addmycourse.util.CourseItem

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()) {

    val allCourses: LazyPagingItems<Course> = homeViewModel.allCourses.collectAsLazyPagingItems()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(onSearchClicked = {}) },
        content = { contentPadding ->
            Box(modifier = Modifier.padding(contentPadding)) {

                val isCourseDataAvailable = handlePagingResult(allCourses = allCourses)
                if (isCourseDataAvailable) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(count = allCourses.itemCount) { index ->
                            allCourses[index]?.let { course ->
                                CourseItem(courseItem = course)
                            }
                        }
                    }
                }

            }
        })

}

@Composable
fun handlePagingResult(allCourses: LazyPagingItems<Course>): Boolean {
    allCourses.apply {
        val error = when {
            loadState.refresh is LoadState.Error -> allCourses.loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> allCourses.loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> allCourses.loadState.append as LoadState.Error
            else -> null
        }

        return when {
            loadState.refresh is LoadState.Loading -> {
                ShimmerEffect()
                false
            }

            error != null -> {
                ErrorScreen(loadState = error)
                false
            }

            else ->
                true
        }
    }
}