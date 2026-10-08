package com.cheemala.addmycourse.component

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheemala.addmycourse.ui.theme.shimmerColor
import com.cheemala.addmycourse.ui.theme.shimmerContentColor
import com.cheemala.addmycourse.util.CourseItem

@Composable
fun ShimmerEffect() {

    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp), contentPadding = PaddingValues(16.dp)) {
        items(count = 2){
            AnimateShimmerEffect()
        }
    }

}

@Composable
fun AnimateShimmerEffect() {
    val shimmerAnim = rememberInfiniteTransition(label = "shimmer effect")
    val alphaAnim = shimmerAnim.animateFloat(
        initialValue = 0f, targetValue = 1f,
        infiniteRepeatable(tween(durationMillis = 1000), RepeatMode.Reverse),
        label = "shimmer effect"
    )
    ShimmerCourseItem(alpha = alphaAnim.value)
}

@Composable
fun ShimmerCourseItem(alpha: Float) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.shimmerContentColor
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom
        ) {

            Surface(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(0.5f)
                    .height(30.dp)
                    .alpha(alpha),
                color = MaterialTheme.colorScheme.shimmerColor
            ) {}

            Spacer(modifier = Modifier.height(10.dp))

            repeat(3) {
                Surface(
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxWidth()
                        .height(20.dp)
                        .alpha(alpha),
                    color = MaterialTheme.colorScheme.shimmerColor
                ) {}
                Spacer(modifier = Modifier.height(6.dp))
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(5) {
                    Surface(
                        modifier = Modifier
                            .padding(6.dp)
                            .size(20.dp)
                            .alpha(alpha),
                        color = MaterialTheme.colorScheme.shimmerColor
                    ) {}
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }

        }
    }
}

@Preview
@Composable
fun ShimmerPreview() {
    val shimmerAnim = rememberInfiniteTransition(label = "shimmer effect")
    val alphaAnim = shimmerAnim.animateFloat(
        initialValue = 0f, targetValue = 1f,
        infiniteRepeatable(tween(durationMillis = 500), RepeatMode.Reverse),
        label = "shimmer effect"
    )
    ShimmerCourseItem(alpha = alphaAnim.value)
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShimmerDarkPreview() {
    ShimmerCourseItem(alpha = 1f)
}