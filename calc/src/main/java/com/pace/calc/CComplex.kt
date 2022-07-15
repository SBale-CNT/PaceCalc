package com.pace.calc

import com.pace.calc.x.thread.XCoroutines
import kotlinx.coroutines.delay

class CComplex(val cb: Callback) {

    private val secs = 1000L
    fun add(a: Int, b: Int) {
        XCoroutines.default {
            delay(10 * secs)
            cb.addResult(a + b)
        }
    }

    fun sub(a: Int, b: Int) {
        XCoroutines.default {
            delay(3 * secs)
            cb.subResult(a - b)
        }
    }

    fun mul(a: Int, b: Int) {
        XCoroutines.default {
            delay(5 * secs)
            cb.mulResult(a * b.toDouble())
        }
    }

    fun div(a: Int, b: Int) {
        XCoroutines.default {
            delay(2 * secs)
            cb.divResult(a / b.toFloat())
        }
    }

    interface Callback {
        fun addResult(c: Int)
        fun subResult(c: Int)
        fun mulResult(c: Double)
        fun divResult(c: Float)
    }
}

