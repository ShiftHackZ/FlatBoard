package com.shifthackz.flatboard.base

import androidx.activity.OnBackPressedCallback

fun interface OnBackPressedEnabled {
    fun isEnabled(value: Boolean)
}

inline fun provideOnBackPressedCallback(
    default: Boolean = true,
    crossinline handle: (OnBackPressedEnabled) -> Unit
): OnBackPressedCallback =
    object : OnBackPressedCallback(default) {
        override fun handleOnBackPressed() =
            handle(OnBackPressedEnabled { value -> isEnabled = value })
    }