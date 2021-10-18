package com.shifthackz.flatboard.keyboard.numeric.custom

import com.shifthackz.flatboard.keyboard.numeric.base.BaseNumeric
import com.shifthackz.flatboard.keyboard.numeric.base.NumericType

//➀➁➂➃➄➅➆➇➈➉
object CircleNumeric : BaseNumeric() {
    override val zero = "➉"
    override val one = "➀"
    override val two = "➁"
    override val three = "➂"
    override val four = "➃"
    override val five = "➄"
    override val six = "➅"
    override val seven = "➆"
    override val eight = "➇"
    override val nine = "➈"

    override val numericType = NumericType.CUSTOM

    override fun getNumericName(): String = "Circly numbers"
}