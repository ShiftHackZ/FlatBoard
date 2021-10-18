package com.shifthackz.flatboard.keyboard.numeric.default

import com.shifthackz.flatboard.keyboard.numeric.base.BaseNumeric
import com.shifthackz.flatboard.keyboard.numeric.base.NumericType

object DefaultNumeric: BaseNumeric() {
    override val zero = "0"
    override val one = "1"
    override val two = "2"
    override val three = "3"
    override val four = "4"
    override val five = "5"
    override val six = "6"
    override val seven = "7"
    override val eight = "8"
    override val nine = "9"

    override val numericType = NumericType.DEFAULT

    override fun getNumericName(): String = "Default numbers"
}