package com.shifthackz.flatboard.keyboard.provider

interface KeyboardContract {
    fun reloadKeyboardFont(position: Int)
    fun reloadKeyboardNumeric(position: Int)
}