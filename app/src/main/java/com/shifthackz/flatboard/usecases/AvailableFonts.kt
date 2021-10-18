package com.shifthackz.flatboard.usecases

import com.shifthackz.flatboard.keyboard.font.alphabet.EnglishAlphabet
import com.shifthackz.flatboard.keyboard.font.custom.*
import com.shifthackz.flatboard.keyboard.numeric.custom.CircleNumeric
import com.shifthackz.flatboard.keyboard.numeric.custom.CircleNumericFilled
import com.shifthackz.flatboard.keyboard.numeric.custom.RandomNumeric
import com.shifthackz.flatboard.keyboard.numeric.custom.SimpleNumericBold
import com.shifthackz.flatboard.keyboard.numeric.default.DefaultNumeric
import com.shifthackz.flatboard.keyboard.numeric.default.RomanNumbers
import kotlin.random.Random

object AvailableFonts {
    val fontList = listOf(
            EnglishAlphabet,
            //EmptyFont,
            FullwidthFont,
            CaligraphBold,
            CircleFont,
            CircleTwoFont,
            CurvyFont,
            DragonBold,
            JapStyle,
            SimpleItalic,
            SimpleBold,
            SlimFont,
            StrokedSuperScript,
            Squared,
            StappledFont,
            ThaiEphiopic,
            RandomFont
    )

    fun getRandomFontIndex(): Int = Random.nextInt(1, fontList.size-1)

    val numericList = listOf(
            DefaultNumeric,
            RomanNumbers,
            CircleNumeric,
            CircleNumericFilled,
            SimpleNumericBold,
            RandomNumeric
    )

    fun getRandomNumericIndex(): Int = Random.nextInt(1, numericList.size-1)
}