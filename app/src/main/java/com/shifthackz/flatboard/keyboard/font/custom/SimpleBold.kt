package com.shifthackz.flatboard.keyboard.font.custom

import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.font.base.FontType

//𝐀 𝐁 𝐂 𝐃 𝐄 𝐅 𝐆 𝐇 𝐈 𝐉 𝐊 𝐋 𝐌 𝐍 𝐎 𝐏 𝐐 𝐑 𝐒 𝐓 𝐔 𝐕 𝐖 𝐗 𝐘 𝐙
//𝐚 𝐛 𝐜 𝐝 𝐞 𝐟 𝐠 𝐡 𝐢 𝐣 𝐤 𝐥 𝐦 𝐧 𝐨 𝐩 𝐪 𝐫 𝐬 𝐭 𝐮 𝐯 𝐰 𝐱 𝐲 𝐳
object SimpleBold : BaseFont() {
    override val a = Pair("\uD835\uDC1A", "\uD835\uDC00")
    override val b = Pair("\uD835\uDC1B", "\uD835\uDC01")
    override val c = Pair("\uD835\uDC1C", "\uD835\uDC02")
    override val d = Pair("\uD835\uDC1D", "\uD835\uDC03")
    override val e = Pair("\uD835\uDC1E", "\uD835\uDC04")
    override val f = Pair("\uD835\uDC1F", "\uD835\uDC05")
    override val g = Pair("\uD835\uDC20", "\uD835\uDC06")
    override val h = Pair("\uD835\uDC21", "\uD835\uDC07")
    override val i = Pair("\uD835\uDC22", "\uD835\uDC08")
    override val j = Pair("\uD835\uDC23", "\uD835\uDC09")
    override val k = Pair("\uD835\uDC24", "\uD835\uDC0A")
    override val l = Pair("\uD835\uDC25", "\uD835\uDC0B")
    override val m = Pair("\uD835\uDC26", "\uD835\uDC0C")
    override val n = Pair("\uD835\uDC27", "\uD835\uDC0D")
    override val o = Pair("\uD835\uDC28", "\uD835\uDC0E")
    override val p = Pair("\uD835\uDC29", "\uD835\uDC0F")
    override val q = Pair("\uD835\uDC2A", "\uD835\uDC10")
    override val r = Pair("\uD835\uDC2B", "\uD835\uDC11")
    override val s = Pair("\uD835\uDC2C", "\uD835\uDC12")
    override val t = Pair("\uD835\uDC2D", "\uD835\uDC13")
    override val u = Pair("\uD835\uDC2E", "\uD835\uDC14")
    override val v = Pair("\uD835\uDC2F", "\uD835\uDC15")
    override val w = Pair("\uD835\uDC30", "\uD835\uDC16")
    override val x = Pair("\uD835\uDC31", "\uD835\uDC17")
    override val y = Pair("\uD835\uDC32", "\uD835\uDC18")
    override val z = Pair("\uD835\uDC33", "\uD835\uDC19")

    override val fontType: FontType = FontType.CUSTOM

    override fun getFontName(): String = "Simple Bold"
}