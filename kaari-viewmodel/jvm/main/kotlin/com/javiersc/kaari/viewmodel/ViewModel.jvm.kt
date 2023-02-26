package com.javiersc.kaari.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel

public actual abstract class ViewModel actual constructor() {

    public actual abstract val scope: CoroutineScope

    protected actual fun onCleared() {
        scope.cancel()
    }
}
