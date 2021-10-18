package com.shifthackz.flatboard.keyboard.font.alphabet

import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.font.base.FontType

object EnglishAlphabet : BaseFont() {
    override val a = Pair("a", "A")
    override val b = Pair("b", "B")
    override val c = Pair("c", "C")
    override val d = Pair("d", "D")
    override val e = Pair("e", "E")
    override val f = Pair("f", "F")
    override val g = Pair("g", "G")
    override val h = Pair("h", "H")
    override val i = Pair("i", "I")
    override val j = Pair("j", "J")
    override val k = Pair("k", "K")
    override val l = Pair("l", "L")
    override val m = Pair("m", "M")
    override val n = Pair("n", "N")
    override val o = Pair("o", "O")
    override val p = Pair("p", "P")
    override val q = Pair("q", "Q")
    override val r = Pair("r", "R")
    override val s = Pair("s", "S")
    override val t = Pair("t", "T")
    override val u = Pair("u", "U")
    override val v = Pair("v", "V")
    override val w = Pair("w", "W")
    override val x = Pair("x", "X")
    override val y = Pair("y", "Y")
    override val z = Pair("z", "Z")

    override val fontType: FontType = FontType.DEFAULT

    override fun getFontName(): String = "Default English"
}
