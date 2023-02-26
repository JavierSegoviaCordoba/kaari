package com.javiersc.samples.strategies.characters

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.javiersc.kaari.samples.strategies.internal.CharacterEntity
import com.javiersc.kaari.samples.strategies.internal.KaariDatabase
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface GetCharacters {
    operator fun invoke(): Flow<List<Character>>
}

class GetCharactersImpl(
    private val coroutineContext: CoroutineContext,
    private val database: KaariDatabase,
) : GetCharacters {

    override fun invoke(): Flow<List<Character>> =
        database.characterQueries
            .selectAll()
            .asFlow()
            .mapToList(coroutineContext)
            .map(List<CharacterEntity>::toCharacters)
}

private fun List<CharacterEntity>.toCharacters(): List<Character> =
    map(CharacterEntity::toCharacter)

private fun CharacterEntity.toCharacter(): Character = Character(id, name)
