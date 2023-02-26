package com.javiersc.samples.features

import androidx.compose.runtime.Composable
import com.javiersc.samples.features._theme.ComposePlaygroundTheme

@Composable
fun KaariPreview(composable: @Composable () -> Unit) {
    ComposePlaygroundTheme { composable() }
}
