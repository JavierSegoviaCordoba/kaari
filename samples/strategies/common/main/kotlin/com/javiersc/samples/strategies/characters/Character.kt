package com.javiersc.samples.strategies.characters

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val id: String,
    val name: String,
)
