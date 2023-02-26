package com.javiersc.kaari.presenter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import app.cash.molecule.RecompositionClock
import app.cash.molecule.moleculeFlow
import app.cash.turbine.test
import com.javiersc.kaari.viewmodel.KaariViewModel
import io.kotest.matchers.shouldBe
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.test.Test
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest

class KaariViewModelTest {

    @Test
    fun `given a datasource when emits 4 values then state is changed 4 times`() = runTest {
        moleculeFlow(RecompositionClock.Immediate) {
                val presenter = FooKaariPresenter(this)
                val state = presenter.state()
                launch {
                    delay(100)
                    presenter.effect { FooEffect.Foo }
                    delay(100)
                    presenter.effect(FooEffect.Bar)
                }
                state
            }
            .test {
                awaitItem() shouldBe FooState("Unknown", 0)
                awaitItem() shouldBe FooState("Foo", 1)
                awaitItem() shouldBe FooState("Bar", 2)
                cancel()
            }
    }
}

private class FooKaariPresenter(scope: CoroutineScope = CoroutineScope(EmptyCoroutineContext)) :
    KaariViewModel<FooEffect, FooState>(scope) {

    @Composable
    override fun state(): FooState {
        var name: String by remember { mutableStateOf("Unknown") }
        var counter: Int by remember { mutableStateOf(0) }

        CollectedEffect { effect ->
            when (effect) {
                FooEffect.Foo -> {
                    name = "Foo"
                    counter = 1
                }
                FooEffect.Bar -> {
                    name = "Bar"
                    counter = 2
                }
            }
        }
        return FooState(name, counter)
    }
}

private data class FooState(val name: String, val counter: Int?)

sealed class FooEffect {

    object Foo : FooEffect()
    object Bar : FooEffect()
}
