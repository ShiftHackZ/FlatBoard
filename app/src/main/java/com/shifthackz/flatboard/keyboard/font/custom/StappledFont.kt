package com.shifthackz.flatboard.keyboard.font.custom

import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.font.base.FontType

//⒜⒝⒞⒟⒠⒡⒢⒣⒤⒥⒦⒧⒨⒩⒪⒫⒬⒭⒮⒯⒰⒱⒲⒳⒴⒵
object StappledFont : BaseFont() {
    override val a = Pair("⒜", "⒜")
    override val b = Pair("⒝", "⒝")
    override val c = Pair("⒞", "⒞")
    override val d = Pair("⒟", "⒟")
    override val e = Pair("⒠", "⒠")
    override val f = Pair("⒡", "⒡")
    override val g = Pair("⒢", "⒢")
    override val h = Pair("⒣", "⒣")
    override val i = Pair("⒤", "⒤")
    override val j = Pair("⒥", "⒥")
    override val k = Pair("⒦", "⒦")
    override val l = Pair("⒧", "⒧")
    override val m = Pair("⒧", "⒧")
    override val n = Pair("⒩", "⒩")
    override val o = Pair("⒪", "⒪")
    override val p = Pair("⒫", "⒫")
    override val q = Pair("⒬", "⒬")
    override val r = Pair("⒭", "⒭")
    override val s = Pair("⒮", "⒮")
    override val t = Pair("⒯", "⒯")
    override val u = Pair("⒰", "⒰")
    override val v = Pair("⒱", "⒱")
    override val w = Pair("⒲", "⒲")
    override val x = Pair("⒳", "⒳")
    override val y = Pair("⒴", "⒴")
    override val z = Pair("⒵", "⒵")

    override val fontType: FontType = FontType.CUSTOM

    override fun getFontName(): String = "Stappled"
}