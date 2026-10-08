package com.cheemala.addmycourse.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import com.cheemala.addmycourse.ui.theme.errorScreenBackgroundColor
import com.cheemala.addmycourse.ui.theme.errorTxtColor
import com.cheemala.addmycourse.util.CommonTextView

@Composable
fun ErrorScreen(loadState: LoadState.Error) {

    val errorObj: ErrorScreenComponents = remember {
        when {
            loadState.error.toString()
                .contains("ConnectException") -> ErrorScreenComponents.NoInternetError

            loadState.error.toString()
                .contains("SocketTimeoutException") -> ErrorScreenComponents.ServerError

            else -> ErrorScreenComponents.UnknownError
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp),
        color = MaterialTheme.colorScheme.errorScreenBackgroundColor
    ) {

        Column(
            modifier = Modifier.padding(6.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                painterResource(errorObj.errorImg),
                contentDescription = "Error Image",
                tint = Color.Unspecified,
                modifier = Modifier
                    .height(150.dp)
                    .graphicsLayer(alpha = 0.2f)
            )
            CommonTextView(
                modifier = Modifier.padding(top = 12.dp), text = errorObj.errorDescription,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                textColor = MaterialTheme.colorScheme.errorTxtColor
            )

        }

    }

}

@Preview
@Composable
fun ErrorScreenPreview() {
    ErrorScreen(loadState = LoadState.Error(Throwable("Unknown Error")))
}