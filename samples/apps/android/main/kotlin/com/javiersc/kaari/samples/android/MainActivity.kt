package com.javiersc.kaari.samples.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.javiersc.samples.features._theme.ComposePlaygroundTheme
import com.javiersc.samples.features.main.MainEffect
import com.javiersc.samples.features.main.MainScreen
import com.javiersc.samples.features.main.MainState
import com.javiersc.samples.features.main.MainViewModel
import com.javiersc.samples.strategies.characters.Character
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposePlaygroundTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main") {
                    composable("main") {
                        val mainViewModel: MainViewModel = getViewModel()
                        MainScreen(
                            mainViewModel.state(),
                            onAddCharacter = {
                                mainViewModel.effect { MainEffect.AddCharacter(it) }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    ComposePlaygroundTheme {
        MainScreen(
            state =
                MainState(
                    isLoading = false,
                    characters = listOf(Character(id = "k2k3m2k", name = "Foo")),
                ),
            onAddCharacter = {},
        )
    }
}
