package com.javiersc.samples.features._theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

@Composable
actual fun colorScheme(dynamicColor: Boolean, isDarkTheme: Boolean): ColorScheme = LightColorScheme

@Composable actual fun AndroidConfig(colorScheme: ColorScheme, isDarkTheme: Boolean) {}
