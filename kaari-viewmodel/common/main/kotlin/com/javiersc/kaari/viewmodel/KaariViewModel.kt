package com.javiersc.kaari.viewmodel

import com.javiersc.kaari.presentation.core.KaariPresentation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow

public abstract class KaariViewModel<Effect, State>(override val scope: CoroutineScope) :
    ViewModel(), KaariPresentation<Effect, State> {

    override val events: MutableSharedFlow<Effect> = MutableSharedFlow(extraBufferCapacity = 20)
}
