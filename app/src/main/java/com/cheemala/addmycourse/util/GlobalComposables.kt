package com.cheemala.addmycourse.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cheemala.addmycourse.R
import com.cheemala.addmycourse.ui.theme.OnBoardingTextColor

object GlobalComposables {

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

        Text(modifier = modifier,
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
    fun CommonButton(modifier: Modifier = Modifier, text: String, color:Int, textColor: Int, cornerRadius: Dp = 10.dp, fontWeight: FontWeight = FontWeight.Bold, btnClick : ()-> Unit){
        Button(modifier = modifier.background(color = colorResource(id = color)), shape = RoundedCornerShape(cornerRadius), onClick = { btnClick() }){
            Text(modifier = Modifier.fillMaxWidth(), text = text, color = Color(textColor), textAlign = TextAlign.Center, fontWeight = fontWeight)
        }
    }

}