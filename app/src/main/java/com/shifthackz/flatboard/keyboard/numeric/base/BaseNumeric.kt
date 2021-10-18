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

    open fun getRenderedSample(): String = "$one $two $three $four $five $six $seven $eight $nine $zero"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseNumeric

        if (zero != other.zero) return false
        if (one != other.one) return false
        if (two != other.two) return false
        if (three != other.three) return false
        if (four != other.four) return false
        if (five != other.five) return false
        if (six != other.six) return false
        if (seven != other.seven) return false
        if (eight != other.eight) return false
        if (nine != other.nine) return false
        if (numericType != other.numericType) return false

        return true
    }

    override fun hashCode(): Int {
        var result = zero.hashCode()
        result = 31 * result + one.hashCode()
        result = 31 * result + two.hashCode()
        result = 31 * result + three.hashCode()
        result = 31 * result + four.hashCode()
        result = 31 * result + five.hashCode()
        result = 31 * result + six.hashCode()
        result = 31 * result + seven.hashCode()
        result = 31 * result + eight.hashCode()
        result = 31 * result + nine.hashCode()
        result = 31 * result + numericType.hashCode()
        return result
    }
}