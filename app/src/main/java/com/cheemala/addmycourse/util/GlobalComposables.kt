package com.cheemala.addmycourse.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import coil3.compose.AsyncImage
import com.cheemala.addmycourse.R
import com.cheemala.addmycourse.domain.model.Course
import com.cheemala.addmycourse.ui.theme.OnBoardingTextColor
import com.cheemala.addmycourse.ui.theme.topAppBarContentColor
import com.cheemala.addmycourse.util.AppConstant.BASE_URL

// Removed the object GlobalComposables wrapper to fix the NoSuchMethodException in Compose Preview.
// Top-level functions are more idiomatic for utility composables and avoid instantiation issues.

@Composable
fun CommonTextView(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit,
    textColor: Color = MaterialTheme.colorScheme.OnBoardingTextColor,
    fontWeight: FontWeight,
    fontFamily: FontFamily,
    letterSpacing: TextUnit = 1.sp,
    textAlign: TextAlign = TextAlign.Center,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {

    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        color = textColor,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        letterSpacing = letterSpacing
    )

}

@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Int,
    textColor: Int,
    cornerRadius: Dp = 10.dp,
    fontWeight: FontWeight = FontWeight.Bold,
    btnClick: () -> Unit
) {
    Button(
        modifier = modifier.background(color = colorResource(id = color)),
        shape = RoundedCornerShape(cornerRadius),
        onClick = { btnClick() }) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            color = colorResource(id = textColor),
            textAlign = TextAlign.Center,
            fontWeight = fontWeight
        )
    }
}

@Composable
fun CourseItem(courseItem: Course) {

    Box(modifier = Modifier.height(400.dp), contentAlignment = Alignment.BottomStart) {
        Surface(
            shape = RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp,
                bottomStart = 20.dp,
                bottomEnd = 20.dp
            ),
            modifier = Modifier
                .fillMaxSize()
                .clipToBounds()
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = "$BASE_URL${courseItem.banner_img}",
                placeholder = painterResource(R.drawable.icon_placeholder),
                error = painterResource(R.drawable.icon_placeholder),
                contentScale = ContentScale.Crop,
                contentDescription = "Course Image"
            )
        }

        Surface(
            shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .clipToBounds(),
            color = Color.Black.copy(alpha = 0.5f)
        ) {
            Column(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                CommonTextView(
                    text = courseItem.course_name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textColor = MaterialTheme.colorScheme.topAppBarContentColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                CommonTextView(
                    text = courseItem.description,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    textColor = MaterialTheme.colorScheme.topAppBarContentColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

}

