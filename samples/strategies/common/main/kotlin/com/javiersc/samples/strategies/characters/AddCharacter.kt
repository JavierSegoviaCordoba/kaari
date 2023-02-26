package com.javiersc.samples.strategies.characters

import com.javiersc.kaari.samples.strategies.internal.KaariDatabase
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.delay

interface AddCharacter {
    suspend operator fun invoke(character: Character)
}

class AddCharacterImpl(
    private val database: KaariDatabase,
) : AddCharacter {

    override suspend operator fun invoke(character: Character) {
        delay(300.milliseconds)
        val hasCharacter =
            database.characterQueries.selectById(character.id).executeAsOneOrNull() != null
        if (!hasCharacter) {
            database.characterQueries.insert(character.id, character.name)
        }
    }
}
