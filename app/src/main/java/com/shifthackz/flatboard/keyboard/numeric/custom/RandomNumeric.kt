package com.shifthackz.flatboard.keyboard.numeric.custom

import com.shifthackz.flatboard.keyboard.font.custom.RandomFont
import com.shifthackz.flatboard.keyboard.numeric.base.BaseNumeric
import com.shifthackz.flatboard.keyboard.numeric.base.NumericType
import com.shifthackz.flatboard.usecases.AvailableFonts

object RandomNumeric : BaseNumeric() {
    override lateinit var zero: String
    override lateinit var one: String
    override lateinit var two: String
    override lateinit var three: String
    override lateinit var four: String
    override lateinit var five: String
    override lateinit var six: String
    override lateinit var seven: String
    override lateinit var eight: String
    override lateinit var nine: String

    override val numericType = NumericType.RANDOM

    override fun getNumericName(): String = "Random numbers"

    override fun getRenderedSample() = "Click here to generate"

    fun generate() {
        zero = AvailableFonts.numericList[AvailableFonts.getRandomNumericIndex()].zero
        one = AvailableFonts.numericList[AvailableFonts.getRandomNumericIndex()].one
        two = AvailableFonts.numericList[AvailableFonts.getRandomNumericIndex()].two
        three = AvailableFonts.numericList[AvailableFonts.getRandomNumericIndex()].three
        four = AvailableFonts.numericList[AvailableFonts.getRandomNumericIndex()].four
        five = AvailableFonts.numericList[AvailableFonts.getRandomNumericIndex()].five
        six = AvailableFonts.numericList[AvailableFonts.getRandomNumericIndex()].six
        seven = AvailableFonts.numericList[AvailableFonts.getRandomNumericIndex()].seven
        eight = AvailableFonts.numericList[AvailableFonts.getRandomNumericIndex()].eight
        nine = AvailableFonts.numericList[AvailableFonts.getRandomNumericIndex()].nine
    }
}