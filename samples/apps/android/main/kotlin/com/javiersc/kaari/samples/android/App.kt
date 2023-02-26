package com.javiersc.kaari.samples.android

import android.app.Application
import com.javiersc.samples.features._di.presentationModule
import com.javiersc.samples.strategies.di.strategiesAndroidModule
import com.javiersc.samples.strategies.di.strategiesModule
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule)
            modules(strategiesModule)
            modules(strategiesAndroidModule)
            modules(presentationModule)
        }
    }
}

val appModule = module { single<CoroutineContext> { EmptyCoroutineContext } }
