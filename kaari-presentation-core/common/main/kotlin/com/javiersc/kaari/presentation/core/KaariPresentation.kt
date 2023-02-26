package com.javiersc.kaari.presentation.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

public interface KaariPresentation<Effect, State> {

    public val scope: CoroutineScope
    public val events: MutableSharedFlow<Effect>

    @Composable public fun state(): State

    @Composable
    public fun CollectedEffect(block: suspend CoroutineScope.(effect: Effect) -> Unit) {
        LaunchedEffect(Unit) { events.collect { effect -> block(this, effect) } }
    }

    public fun effect(effect: () -> Effect) {
        scope.launch { events.emit(effect()) }
    }

    public fun effect(effect: Effect) {
        scope.launch { events.emit(effect) }
    }

    // TODO: Doesn't work due Compose compiler bug
    // @Suppress("NOTHING_TO_INLINE")
    // @Composable
    // inline operator fun getValue(thisObj: Any?, property: KProperty<*>): State = state()
}
