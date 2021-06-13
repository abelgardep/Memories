package com.abelgardep.memories.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = BlueGray200,
    primaryVariant = BlueGray300,
    onPrimary = Color.Black,
    secondary = Orange300,
    secondaryVariant = Orange300,
    onSecondary = Color.Black,
    error = Red200,
    onError = Color.White,
    background = Color.Black,
    surface = Black800
)

private val LightColorPalette = lightColors(
    primary = BlueGray700,
    primaryVariant = BlueGray800,
    onPrimary = Color.White,
    secondary = Orange500,
    secondaryVariant = Orange400,
    onSecondary = Color.Black,
    error = Red400,
    onError = Color.White,
    background = BlueGray50,
    surface = Color.White,
)

@Composable
fun MemoriesTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
