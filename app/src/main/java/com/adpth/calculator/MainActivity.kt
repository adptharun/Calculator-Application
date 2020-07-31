package com.adpth.calculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.adpth.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var operator: String =""
    private var value1:Double = 0.0
    private var value2:Double = 0.0
    private var result :Double = 0.0
    private lateinit var stringBuilder: StringBuilder
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        stringBuilder = StringBuilder()

        binding.apply {

            btn0.setOnClickListener { btn_click(btn0) }
            btn1.setOnClickListener { btn_click(btn1) }
            btn2.setOnClickListener { btn_click(btn2) }
            btn3.setOnClickListener { btn_click(btn3) }
            btn4.setOnClickListener { btn_click(btn4) }
            btn5.setOnClickListener { btn_click(btn5) }
            btn6.setOnClickListener { btn_click(btn6) }
            btn7.setOnClickListener { btn_click(btn7) }
            btn8.setOnClickListener { btn_click(btn8) }
            btn9.setOnClickListener { btn_click(btn9) }
            btnDecimal.setOnClickListener { btn_click(btnDecimal) }
            btnAdd.setOnClickListener { btn_operation(btnAdd) }
            btnMinus.setOnClickListener { btn_operation(btnMinus) }
            btnMul.setOnClickListener { btn_operation(btnMul) }
            btnDiv.setOnClickListener { btn_operation(btnDiv) }
            btnPercentage.setOnClickListener { btn_operation(btnPercentage) }
            btnClear.setOnClickListener{btn_click(btnClear)}
            btnDel.setOnClickListener{btn_click(btnDel)}
            btnResult.setOnClickListener{btn_result()}
        }
    }

    private fun btn_click(visible:View) {

        binding.apply {

            var value= Output.text.toString()

            when(visible.id){

                btn0.id -> {
                    value += "0"
                    stringBuilder.append("0")
                }
                btn1.id -> {
                    value += "1"
                    stringBuilder.append("1")
                }
                btn2.id -> {
                    value += "2"
                    stringBuilder.append("2")
                }
                btn3.id -> {
                    value += "3"
                    stringBuilder.append("3")
                }
                btn4.id -> {
                    value += "4"
                    stringBuilder.append("4")
                }
                btn5.id -> {
                    value += "5"
                    stringBuilder.append("5")
                }
                btn6.id -> {
                    value += "6"
                    stringBuilder.append("6")
                }
                btn7.id -> {
                    value += "7"
                    stringBuilder.append("7")
                }
                btn8.id -> {
                    value += "8"
                    stringBuilder.append("8")
                }
                btn9.id -> {
                    value += "9"
                    stringBuilder.append("9")
                }
                btnDecimal.id -> {
                    value += "."
                    stringBuilder.append(".")
                }
                btnClear.id -> {
                    value = ""
                    stringBuilder.clear()
                }
                btnDel.id -> {
                    //value = Output.text.toString()
                    if(value.isNotEmpty()) {
                        value = value.substring(0,value.length-1)
                    }
                }

            }
            Output.setText(value)

            // stringBuilder.append(value)
            ResultOperation.text = stringBuilder

        }

    }

    private fun btn_operation(visible:View) {

        binding.apply {

            when(visible.id) {
                btnAdd.id -> {operator = "+"}
                btnMinus.id -> {operator = "-"}
                btnDiv.id -> {operator = "/"}
                btnPercentage.id -> {operator = "%"}
                btnMul.id -> {operator = "*"}

            }

            val value = Output.text.toString()
            value1 = value.toDouble()

            Output.text.clear()

            stringBuilder.append(operator)
            //stringBuilder.append(operator)
            ResultOperation.text = stringBuilder
        }

    }

    private fun btn_result(){

        binding.apply {

            val value = Output.text.toString()
            value2 = value.toDouble()

            when(operator){

                "+" -> {
                    result = value1 + value2
                }
                "-" -> {
                    result = value1 - value2
                }
                "/" -> {
                    result = value1 / value2
                }
                "%" -> {
                    result = value1 % value2
                }
                "*" -> {
                    result = value1 * value2
                }
            }

            Output.setText(result.toString())
            stringBuilder.append(" = ")
            stringBuilder.append(result)

        }


    }
}