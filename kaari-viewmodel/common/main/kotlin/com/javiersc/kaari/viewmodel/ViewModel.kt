package com.javiersc.kaari.viewmodel

import kotlinx.coroutines.CoroutineScope

public expect abstract class ViewModel() {

    public abstract val scope: CoroutineScope

    protected fun onCleared()
}
