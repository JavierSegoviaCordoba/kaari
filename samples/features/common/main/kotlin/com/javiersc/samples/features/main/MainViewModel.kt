package com.javiersc.samples.features.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.javiersc.kaari.viewmodel.KaariViewModel
import com.javiersc.samples.strategies.characters.AddCharacter
import com.javiersc.samples.strategies.characters.Character
import com.javiersc.samples.strategies.characters.GetCharacters
import kotlinx.coroutines.CoroutineScope

class MainViewModel(
    scope: CoroutineScope,
    private val getCharacters: GetCharacters,
    private val addCharacter: AddCharacter,
) : KaariViewModel<MainEffect, MainState>(scope) {

    @Composable
    override fun state(): MainState {
        var isLoading: Boolean by remember { mutableStateOf(false) }
        val characters: List<Character> by getCharacters().collectAsState(emptyList())

        CollectedEffect { effect: MainEffect ->
            when (effect) {
                is MainEffect.AddCharacter -> {
                    isLoading = true
                    addCharacter(effect.character)
                    isLoading = false
                }
            }
        }
        return MainState(isLoading, characters)
    }
}

sealed class MainEffect {

    data class AddCharacter(val character: Character) : MainEffect()
}

data class MainState(val isLoading: Boolean, val characters: List<Character>)
