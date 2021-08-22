package com.abelgardep.memories.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.abelgardep.memories.R


val WorkSans = FontFamily(
    Font(R.font.worksans_light, FontWeight.Light),
    Font(R.font.worksans_regular, FontWeight.Normal),
    Font(R.font.worksans_medium, FontWeight.Medium),
    Font(R.font.worksans_semibold, FontWeight.SemiBold),
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = WorkSans,
        fontSize = 96.sp,
        fontWeight = FontWeight.Light,
    ),
    h2 = TextStyle(
        fontFamily = WorkSans,
        fontSize = 60.sp,
        fontWeight = FontWeight.Light,
    ),
    h3 = TextStyle(
        fontFamily = WorkSans,
        fontSize = 48.sp,
        fontWeight = FontWeight.Normal,
    ),
    h4 = TextStyle(
        fontFamily = WorkSans,
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    h5 = TextStyle(
        fontFamily = WorkSans,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    h6 = TextStyle(
        fontFamily = WorkSans,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    subtitle1 = TextStyle(
        fontFamily = WorkSans,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    subtitle2 = TextStyle(
        fontFamily = WorkSans,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
    ),
    body1 = TextStyle(
        fontFamily = WorkSans,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
    ),
    body2 = TextStyle(
        fontFamily = WorkSans,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
    ),
    button = TextStyle(
        fontFamily = WorkSans,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    caption = TextStyle(
        fontFamily = WorkSans,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
    ),
    overline = TextStyle(
        fontFamily = WorkSans,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
    )
)
