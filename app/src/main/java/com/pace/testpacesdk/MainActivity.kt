package com.pace.testpacesdk

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.pace.calc.CComplex
import com.pace.calc.OBasic

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        simpleCalc()
        complexCalc()
    }

    private fun simpleCalc() {
        val add = OBasic.add(20, 10).toString()
        val sub = OBasic.sub(20, 10).toString()
        val mul = OBasic.mul(20, 10).toString()
        val div = OBasic.div(20, 10).toString()

        Log.e("OBasic", "Add = $add")
        Log.e("OBasic", "Sub = $sub")
        Log.e("OBasic", "Mul = $mul")
        Log.e("OBasic", "Div = $div")
    }

    private fun complexCalc() {
        val callback = object : CComplex.Callback {
            override fun addResult(c: Int) {
                Log.e("CComplex", "Add = $c")
            }

            override fun subResult(c: Int) {
                Log.e("CComplex", "Sub = $c")
            }

            override fun mulResult(c: Double) {
                Log.e("CComplex", "Mul = $c")
            }

            override fun divResult(c: Float) {
                Log.e("CComplex", "Div = $c")
            }
        }

        val cc = CComplex(callback)
        cc.add(40, 10)
        cc.sub(40, 10)
        cc.mul(40, 10)
        cc.div(40, 10)
    }
}