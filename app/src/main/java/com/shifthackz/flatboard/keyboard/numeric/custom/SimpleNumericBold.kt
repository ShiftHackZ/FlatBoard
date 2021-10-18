package com.shifthackz.flatboard.keyboard.numeric.custom

import com.shifthackz.flatboard.keyboard.numeric.base.BaseNumeric
import com.shifthackz.flatboard.keyboard.numeric.base.NumericType

//𝟎𝟏𝟐𝟑𝟒𝟓𝟔𝟕𝟖𝟗
object SimpleNumericBold : BaseNumeric() {
    override val zero = "\uD835\uDFCE"
    override val one = "\uD835\uDFCF"
    override val two = "\uD835\uDFD0"
    override val three = "\uD835\uDFD1"
    override val four = "\uD835\uDFD2"
    override val five = "\uD835\uDFD3"
    override val six = "\uD835\uDFD4"
    override val seven = "\uD835\uDFD5"
    override val eight = "\uD835\uDFD6"
    override val nine = "\uD835\uDFD7"

    override val numericType = NumericType.CUSTOM

    override fun getNumericName(): String = "Solid bold numbers"
}