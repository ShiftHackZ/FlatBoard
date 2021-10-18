package com.shifthackz.flatboard.keyboard.numeric.default

import com.shifthackz.flatboard.keyboard.numeric.base.BaseNumeric
import com.shifthackz.flatboard.keyboard.numeric.base.NumericType

object RomanNumbers: BaseNumeric() {
    override val zero = "X"
    override val one = "I"
    override val two = "II"
    override val three = "III"
    override val four = "IV"
    override val five = "V"
    override val six = "VI"
    override val seven = "VII"
    override val eight = "VIII"
    override val nine = "IX"

    override val numericType = NumericType.DEFAULT

    override fun getNumericName(): String = "Roman numbers"
}