package com.javiersc.samples.features._di

import com.javiersc.samples.features.main.MainViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val presentationModule = module { singleOf(::MainViewModel) }
