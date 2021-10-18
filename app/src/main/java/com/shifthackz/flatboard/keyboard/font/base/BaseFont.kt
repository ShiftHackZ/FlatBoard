package com.shifthackz.flatboard.keyboard.font.base

abstract class BaseFont {
    abstract val a: Pair<String, String>
    abstract val b: Pair<String, String>
    abstract val c: Pair<String, String>
    abstract val d: Pair<String, String>
    abstract val e: Pair<String, String>
    abstract val f: Pair<String, String>
    abstract val g: Pair<String, String>
    abstract val h: Pair<String, String>
    abstract val i: Pair<String, String>
    abstract val j: Pair<String, String>
    abstract val k: Pair<String, String>
    abstract val l: Pair<String, String>
    abstract val m: Pair<String, String>
    abstract val n: Pair<String, String>
    abstract val o: Pair<String, String>
    abstract val p: Pair<String, String>
    abstract val q: Pair<String, String>
    abstract val r: Pair<String, String>
    abstract val s: Pair<String, String>
    abstract val t: Pair<String, String>
    abstract val u: Pair<String, String>
    abstract val v: Pair<String, String>
    abstract val w: Pair<String, String>
    abstract val x: Pair<String, String>
    abstract val y: Pair<String, String>
    abstract val z: Pair<String, String>

    abstract val fontType: FontType

    abstract fun getFontName(): String

    open fun getRenderedSample(): String = s.second+a.first+m.first+p.first+l.first+e.first

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseFont

        if (a != other.a) return false
        if (b != other.b) return false
        if (c != other.c) return false
        if (d != other.d) return false
        if (e != other.e) return false
        if (f != other.f) return false
        if (g != other.g) return false
        if (h != other.h) return false
        if (i != other.i) return false
        if (j != other.j) return false
        if (k != other.k) return false
        if (l != other.l) return false
        if (m != other.m) return false
        if (n != other.n) return false
        if (o != other.o) return false
        if (p != other.p) return false
        if (q != other.q) return false
        if (r != other.r) return false
        if (s != other.s) return false
        if (t != other.t) return false
        if (u != other.u) return false
        if (v != other.v) return false
        if (w != other.w) return false
        if (x != other.x) return false
        if (y != other.y) return false
        if (z != other.z) return false
        if (fontType != other.fontType) return false

        return true
    }

    override fun hashCode(): Int {
        var result = a.hashCode()
        result = 31 * result + b.hashCode()
        result = 31 * result + c.hashCode()
        result = 31 * result + d.hashCode()
        result = 31 * result + e.hashCode()
        result = 31 * result + f.hashCode()
        result = 31 * result + g.hashCode()
        result = 31 * result + h.hashCode()
        result = 31 * result + i.hashCode()
        result = 31 * result + j.hashCode()
        result = 31 * result + k.hashCode()
        result = 31 * result + l.hashCode()
        result = 31 * result + m.hashCode()
        result = 31 * result + n.hashCode()
        result = 31 * result + o.hashCode()
        result = 31 * result + p.hashCode()
        result = 31 * result + q.hashCode()
        result = 31 * result + r.hashCode()
        result = 31 * result + s.hashCode()
        result = 31 * result + t.hashCode()
        result = 31 * result + u.hashCode()
        result = 31 * result + v.hashCode()
        result = 31 * result + w.hashCode()
        result = 31 * result + x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        result = 31 * result + fontType.hashCode()
        return result
    }
}