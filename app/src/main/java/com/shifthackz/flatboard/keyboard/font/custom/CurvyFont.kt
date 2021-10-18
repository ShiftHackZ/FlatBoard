package com.shifthackz.flatboard.keyboard.font.custom

import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.font.base.FontType

//ค๒ƈɗﻉिﻭɦٱﻝᛕɭ๓กѻρ۹ɼรՇપ۷ฝซץչ
//αв¢∂єƒﻭнιנкℓмησρ۹яѕтυνωχуչ
object CurvyFont : BaseFont() {
    override val a = Pair("α", "ค")
    override val b = Pair("в", "๒")
    override val c = Pair("¢", "ƈ")
    override val d = Pair("∂", "ɗ")
    override val e = Pair("є", "ﻉ")
    override val f = Pair("ƒ", "ि")
    override val g = Pair("ﻭ", "ﻭ")
    override val h = Pair("н", "ɦ")
    override val i = Pair("ι", "ٱ")
    override val j = Pair("נ", "ﻝ")
    override val k = Pair("к", "ᛕ")
    override val l = Pair("ℓ", "ɭ")
    override val m = Pair("м", "๓")
    override val n = Pair("η", "ก")
    override val o = Pair("σ", "ѻ")
    override val p = Pair("ρ", "ρ")
    override val q = Pair("۹", "۹")
    override val r = Pair("я", "ɼ")
    override val s = Pair("ѕ", "ร")
    override val t = Pair("т", "Շ")
    override val u = Pair("υ", "પ")
    override val v = Pair("ν", "۷")
    override val w = Pair("ω", "ฝ")
    override val x = Pair("χ", "ซ")
    override val y = Pair("y", "ץ")
    override val z = Pair("չ", "չ")

    override val fontType: FontType = FontType.CUSTOM

    override fun getFontName(): String = "Curvy pseudo alphabet"
}