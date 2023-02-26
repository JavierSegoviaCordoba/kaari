package com.javiersc.kaari.presenter

import com.javiersc.kaari.presentation.core.KaariPresentation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow

public abstract class KaariPresenter<Effect, State>(
    override val scope: CoroutineScope,
) : KaariPresentation<Effect, State> {

    override val events: MutableSharedFlow<Effect> = MutableSharedFlow(extraBufferCapacity = 20)
}
