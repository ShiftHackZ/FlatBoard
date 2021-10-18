package com.shifthackz.flatboard.keyboard.font.custom

import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.font.base.FontType

//ᗩ ᗷ ᑕ ᗪ ᗴ ᖴ Ǥ ᕼ Ꭵ ᒎ ᛕ ᒪ ᗰ ᑎ ᗝ ᑭ Ɋ ᖇ ᔕ 丅 ᑌ ᐯ ᗯ ᙭ Ƴ 乙
//卂 乃 匚 ᗪ 乇 千 Ꮆ 卄 丨 ﾌ Ҝ ㄥ 爪 几 ㄖ 卩 Ɋ 尺 丂 ㄒ ㄩ ᐯ 山 乂 ㄚ 乙
object JapStyle : BaseFont() {
    override val a = Pair("ᗩ", "卂")
    override val b = Pair("ᗷ", "乃")
    override val c = Pair("ᑕ", "匚")
    override val d = Pair("ᗪ", "ᗪ")
    override val e = Pair("ᗴ", "乇")
    override val f = Pair("ᖴ", "千")
    override val g = Pair("Ǥ", "Ꮆ")
    override val h = Pair("ᕼ", "卄")
    override val i = Pair("Ꭵ", "丨")
    override val j = Pair("ᒎ", "ﾌ")
    override val k = Pair("ᛕ", "Ҝ")
    override val l = Pair("ᒪ", "ㄥ")
    override val m = Pair("ᗰ", "爪")
    override val n = Pair("ᑎ", "几")
    override val o = Pair("ᗝ", "ㄖ")
    override val p = Pair("ᑭ", "卩")
    override val q = Pair("Ɋ", "Ɋ")
    override val r = Pair("ᖇ", "尺")
    override val s = Pair("ᔕ", "丂")
    override val t = Pair("丅", "ㄒ")
    override val u = Pair("ᑌ", "ㄩ")
    override val v = Pair("ᐯ", "ᐯ")
    override val w = Pair("ᗯ", "山")
    override val x = Pair("᙭", "乂")
    override val y = Pair("Ƴ", "ㄚ")
    override val z = Pair("乙", "乙")

    override val fontType: FontType = FontType.CUSTOM

    override fun getFontName(): String = "Jap style"
}