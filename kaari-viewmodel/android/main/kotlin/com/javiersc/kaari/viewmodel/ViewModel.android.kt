package com.javiersc.kaari.viewmodel

import androidx.lifecycle.ViewModel as AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel

public actual abstract class ViewModel : AndroidViewModel() {

    public actual abstract val scope: CoroutineScope

    actual override fun onCleared() {
        super.onCleared()

        scope.cancel()
    }
}
