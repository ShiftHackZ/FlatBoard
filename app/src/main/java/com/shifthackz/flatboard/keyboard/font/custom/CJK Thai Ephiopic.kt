package com.shifthackz.flatboard.keyboard.font.custom

import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.font.base.FontType

//ﾑ乃cd乇ｷgんﾉﾌズﾚﾶ刀oｱq尺丂ｲu√wﾒﾘ乙
//ልጌርዕቿቻኗዘጎጋጕረጠክዐየዒዪነፕሁሀሠሸሃጊ
object ThaiEphiopic : BaseFont() {
    override val a = Pair("ﾑ", "ል")
    override val b = Pair("乃", "ጌ")
    override val c = Pair("c", "ር")
    override val d = Pair("d", "ዕ")
    override val e = Pair("乇", "ቿ")
    override val f = Pair("ｷ", "ቻ")
    override val g = Pair("g", "ኗ")
    override val h = Pair("ん", "ዘ")
    override val i = Pair("ﾉ", "ጎ")
    override val j = Pair("ﾌ", "ጋ")
    override val k = Pair("ズ", "ጕ")
    override val l = Pair("ﾚ", "ረ")
    override val m = Pair("ﾶ", "ጠ")
    override val n = Pair("刀", "ክ")
    override val o = Pair("o", "ዐ")
    override val p = Pair("ｱ", "የ")
    override val q = Pair("q", "ዒ")
    override val r = Pair("尺", "ዪ")
    override val s = Pair("丂", "ነ")
    override val t = Pair("ｲ", "ፕ")
    override val u = Pair("u", "ሁ")
    override val v = Pair("√", "ሀ")
    override val w = Pair("w", "ሠ")
    override val x = Pair("ﾒ", "ሸ")
    override val y = Pair("ﾘ", "ሃ")
    override val z = Pair("乙", "ጊ")

    override val fontType: FontType = FontType.CUSTOM

    override fun getFontName(): String = "CJK Thai Ephiopic"
}