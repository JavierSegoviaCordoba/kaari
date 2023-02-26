package com.javiersc.samples.features.main

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.javiersc.samples.strategies.characters.Character
import java.util.*

@Composable
fun MainScreen(
    state: MainState,
    onAddCharacter: (Character) -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Characters") },
            )
        },
        content = {
            if (state.isLoading) CircularProgressIndicator()

            LazyColumn(
                modifier = Modifier.padding(it).padding(16.dp),
                content = {
                    item {
                        Button(
                            onClick = {
                                val uuid = UUID.randomUUID().toString()
                                onAddCharacter(
                                    Character(
                                        id = uuid,
                                        name = "Foo + ${uuid.take(7)}",
                                    ),
                                )
                            },
                            content = { Text(text = "Add") },
                        )
                    }
                    items(state.characters) { character ->
                        Character(
                            name = character.name,
                        )
                    }
                }
            )
        }
    )
}

@Composable
fun Character(name: String) {
    Text(name)
}
