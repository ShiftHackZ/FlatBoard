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
}