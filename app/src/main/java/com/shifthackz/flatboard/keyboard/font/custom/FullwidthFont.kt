package com.shifthackz.flatboard.keyboard.font.custom

import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.font.base.FontType

//ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ
//ᵃᵇᶜᵈᵉᶠᵍʰⁱʲᵏˡᵐⁿᵒᵖqʳˢᵗᵘᵛʷˣʸᶻ
object FullwidthFont : BaseFont() {
    override val a = Pair("ᵃ", "ａ")
    override val b = Pair("ᵇ", "ｂ")
    override val c = Pair("ᶜ", "ｃ")
    override val d = Pair("ᵈ", "ｄ")
    override val e = Pair("ᵉ", "ｅ")
    override val f = Pair("ᶠ", "ｆ")
    override val g = Pair("ᵍ", "ｇ")
    override val h = Pair("ʰ", "ｈ")
    override val i = Pair("ⁱ", "ｉ")
    override val j = Pair("ʲ", "ｊ")
    override val k = Pair("ᵏ", "ｋ")
    override val l = Pair("ˡ", "ｌ")
    override val m = Pair("ᵐ", "ｍ")
    override val n = Pair("ⁿ", "ｎ")
    override val o = Pair("ᵒ", "ｏ")
    override val p = Pair("ᵖ", "ｐ")
    override val q = Pair("q", "ｑ")
    override val r = Pair("ʳ", "ｒ")
    override val s = Pair("ˢ", "ｓ")
    override val t = Pair("ᵗ", "ｔ")
    override val u = Pair("ᵘ", "ｕ")
    override val v = Pair("ᵛ", "ｖ")
    override val w = Pair("ʷ", "ｗ")
    override val x = Pair("ˣ", "ｘ")
    override val y = Pair("ʸ", "ｙ")
    override val z = Pair("ᶻ", "ｚ")

    override val fontType: FontType = FontType.CUSTOM

    override fun getFontName(): String = "Fullwidth"
}