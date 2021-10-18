package com.shifthackz.flatboard.keyboard.font.custom

import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.font.base.FontType

//Ⱥƀȼđɇfǥħɨɉꝁłmnøᵽꝗɍsŧᵾvwxɏƶ
//äḅċḋëḟġḧïjḳḷṁṅöṗqṛṡẗüṿẅẍÿż
object StrokedSuperScript : BaseFont() {
    override val a = Pair("ä", "Ⱥ")
    override val b = Pair("ḅ", "ƀ")
    override val c = Pair("ċ", "ȼ")
    override val d = Pair("ḋ", "đ")
    override val e = Pair("ë", "ɇ")
    override val f = Pair("ḟ", "f")
    override val g = Pair("ġ", "ǥ")
    override val h = Pair("ḧ", "ħ")
    override val i = Pair("ï", "ɨ")
    override val j = Pair("j", "ɉ")
    override val k = Pair("ḳ", "ꝁ")
    override val l = Pair("ḷ", "ł")
    override val m = Pair("ṁ", "m")
    override val n = Pair("ṅ", "n")
    override val o = Pair("ö", "ø")
    override val p = Pair("ṗ", "ᵽ")
    override val q = Pair("q", "ꝗ")
    override val r = Pair("ṛ", "ɍ")
    override val s = Pair("ṡ", "s")
    override val t = Pair("ẗ", "ŧ")
    override val u = Pair("ü", "ᵾ")
    override val v = Pair("ṿ", "v")
    override val w = Pair("ẅ", "w")
    override val x = Pair("ẍ", "x")
    override val y = Pair("ÿ", "ɏ")
    override val z = Pair("ż", "ƶ")

    override val fontType: FontType = FontType.CUSTOM

    override fun getFontName(): String = "Rock dots super script"
}