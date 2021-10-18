package com.shifthackz.flatboard.keyboard.font.custom

import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.font.base.FontType

//𝔸𝔹ℂ𝔻𝔼𝔽𝔾ℍ𝕀𝕁𝕂𝕃𝕄ℕ𝕆ℙℚℝ𝕊𝕋𝕌𝕍𝕎𝕏𝕐ℤ
//𝕒𝕓𝕔𝕕𝕖𝕗𝕘𝕙𝕚𝕛𝕜𝕝𝕞𝕟𝕠𝕡𝕢𝕣𝕤𝕥𝕦𝕧𝕨𝕩𝕪𝕫
object SlimFont : BaseFont() {
    override val a = Pair("\uD835\uDD52", "\uD835\uDD38")
    override val b = Pair("\uD835\uDD53", "\uD835\uDD39")
    override val c = Pair("\uD835\uDD54", "ℂ")
    override val d = Pair("\uD835\uDD55", "\uD835\uDD3B")
    override val e = Pair("\uD835\uDD56", "\uD835\uDD3C")
    override val f = Pair("\uD835\uDD57", "\uD835\uDD3D")
    override val g = Pair("\uD835\uDD58", "\uD835\uDD3E")
    override val h = Pair("\uD835\uDD59", "ℍ")
    override val i = Pair("\uD835\uDD5A", "\uD835\uDD40")
    override val j = Pair("\uD835\uDD5B", "\uD835\uDD41")
    override val k = Pair("\uD835\uDD5C", "\uD835\uDD42")
    override val l = Pair("\uD835\uDD5D", "\uD835\uDD43")
    override val m = Pair("\uD835\uDD5E", "\uD835\uDD44")
    override val n = Pair("\uD835\uDD5F", "ℕ")
    override val o = Pair("\uD835\uDD60", "\uD835\uDD46")
    override val p = Pair("\uD835\uDD61", "ℙ")
    override val q = Pair("\uD835\uDD62", "ℚ")
    override val r = Pair("\uD835\uDD63", "ℝ")
    override val s = Pair("\uD835\uDD64", "\uD835\uDD4A")
    override val t = Pair("\uD835\uDD65", "\uD835\uDD4B")
    override val u = Pair("\uD835\uDD66", "\uD835\uDD4C")
    override val v = Pair("\uD835\uDD67", "\uD835\uDD4D")
    override val w = Pair("\uD835\uDD68", "\uD835\uDD4E")
    override val x = Pair("\uD835\uDD69", "\uD835\uDD4F")
    override val y = Pair("\uD835\uDD6A", "\uD835\uDD50")
    override val z = Pair("\uD835\uDD6B", "ℤ")

    override val fontType: FontType = FontType.CUSTOM

    override fun getFontName(): String = "Slim"
}