package com.shifthackz.flatboard.keyboard.numeric.custom

import com.shifthackz.flatboard.keyboard.numeric.base.BaseNumeric
import com.shifthackz.flatboard.keyboard.numeric.base.NumericType

//➊➋➌➍➎➏➐➑➒➓
object CircleNumericFilled : BaseNumeric() {
    override val zero = "➓"
    override val one = "➊"
    override val two = "➋"
    override val three = "➌"
    override val four = "➍"
    override val five = "➎"
    override val six = "➏"
    override val seven = "➐"
    override val eight = "➑"
    override val nine = "➒"

    override val numericType = NumericType.CUSTOM

    override fun getNumericName(): String = "Circly fill numbers"
}