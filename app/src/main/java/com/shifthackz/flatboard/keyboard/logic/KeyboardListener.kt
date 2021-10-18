package com.shifthackz.flatboard.keyboard.logic

import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.logic.controllers.KeyboardController
import com.shifthackz.flatboard.keyboard.numeric.base.BaseNumeric

interface KeyboardListener {
    fun characterClicked(c: String)
    fun specialKeyClicked(key: KeyboardController.SpecialKey)
    fun onFontChanged(font: BaseFont)
    fun onNumericChanged(numeric: BaseNumeric)
}