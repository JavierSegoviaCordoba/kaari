package com.javiersc.samples.strategies.di

import com.javiersc.kaari.samples.strategies.internal.KaariDatabase
import com.javiersc.samples.strategies.characters.AddCharacter
import com.javiersc.samples.strategies.characters.AddCharacterImpl
import com.javiersc.samples.strategies.characters.GetCharacters
import com.javiersc.samples.strategies.characters.GetCharactersImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val strategiesModule = module {
    single { KaariDatabase(get()) }
    single { KaariDatabase.Schema }
    singleOf(::AddCharacterImpl).bind<AddCharacter>()
    singleOf(::GetCharactersImpl).bind<GetCharacters>()
}
