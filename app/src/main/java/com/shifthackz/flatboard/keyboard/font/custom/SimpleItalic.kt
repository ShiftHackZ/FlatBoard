package com.shifthackz.flatboard.keyboard.font.custom

import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.font.base.FontType

//𝑨𝑩𝑪𝑫𝑬𝑭𝑮𝑯𝑰𝑱𝑲𝑳𝑴𝑶𝑷𝑸𝑹𝑺𝑻𝑼𝑽𝑾𝑿𝒀𝒁
//𝒂𝒃𝒄𝒅𝒆𝒇𝒈𝒉𝒊𝒋𝒌𝒍𝒎𝒏𝒐𝒑𝒒𝒓𝒔𝒕𝒖𝒗𝒘𝒙𝒚𝒛
object SimpleItalic : BaseFont() {
    override val a = Pair("\uD835\uDC82", "\uD835\uDC68")
    override val b = Pair("\uD835\uDC83", "\uD835\uDC69")
    override val c = Pair("\uD835\uDC84", "\uD835\uDC6A")
    override val d = Pair("\uD835\uDC85", "\uD835\uDC6B")
    override val e = Pair("\uD835\uDC86", "\uD835\uDC6C")
    override val f = Pair("\uD835\uDC87", "\uD835\uDC6D")
    override val g = Pair("\uD835\uDC88", "\uD835\uDC6E")
    override val h = Pair("\uD835\uDC89", "\uD835\uDC6F")
    override val i = Pair("\uD835\uDC8A", "\uD835\uDC70")
    override val j = Pair("\uD835\uDC8B", "\uD835\uDC71")
    override val k = Pair("\uD835\uDC8C", "\uD835\uDC72")
    override val l = Pair("\uD835\uDC8D", "\uD835\uDC73")
    override val m = Pair("\uD835\uDC8E", "\uD835\uDC74")
    override val n = Pair("\uD835\uDC8F", "\uD835\uDC75")
    override val o = Pair("\uD835\uDC90", "\uD835\uDC76")
    override val p = Pair("\uD835\uDC91", "\uD835\uDC77")
    override val q = Pair("\uD835\uDC92", "\uD835\uDC78")
    override val r = Pair("\uD835\uDC93", "\uD835\uDC79")
    override val s = Pair("\uD835\uDC94", "\uD835\uDC7A")
    override val t = Pair("\uD835\uDC95", "\uD835\uDC7B")
    override val u = Pair("\uD835\uDC96", "\uD835\uDC7C")
    override val v = Pair("\uD835\uDC97", "\uD835\uDC7D")
    override val w = Pair("\uD835\uDC98", "\uD835\uDC7E")
    override val x = Pair("\uD835\uDC99", "\uD835\uDC7F")
    override val y = Pair("\uD835\uDC9A", "\uD835\uDC80")
    override val z = Pair("\uD835\uDC9B", "\uD835\uDC81")

    override val fontType: FontType = FontType.CUSTOM

    override fun getFontName(): String = "Simple Italic"
}