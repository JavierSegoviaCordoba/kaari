package com.javiersc.samples.features.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.javiersc.samples.features.KaariPreview
import java.util.UUID

@Preview
@Composable
fun MainScreenPreview() = KaariPreview {
    val uuid = UUID.randomUUID().toString()
    MainScreen(
        MainState(
            isLoading = false,
            characters =
                listOf(
                    com.javiersc.samples.strategies.characters.Character(
                        uuid,
                        "Rick + ${uuid.take(7)}"
                    ),
                ),
        )
    )
}
