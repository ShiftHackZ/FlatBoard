package com.shifthackz.flatboard.keyboard.numeric.base

abstract class BaseNumeric {
    abstract val zero: String
    abstract val one: String
    abstract val two: String
    abstract val three: String
    abstract val four: String
    abstract val five: String
    abstract val six: String
    abstract val seven: String
    abstract val eight: String
    abstract val nine: String

    abstract val numericType: NumericType

    abstract fun getNumericName(): String

    open fun getRenderedSample(): String {
        return "$one $two $three $four $five $six $seven $eight $nine $zero"
    }
}