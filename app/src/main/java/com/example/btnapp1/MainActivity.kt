package com.example.btnapp1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvCounter: TextView
    var counter = 0

    private fun changeTxt(counter: Int) {

        when {
            counter < 0 -> {
                tvCounter.setTextColor(Color.RED)
                tvCounter.translationY = (counter * -1).toFloat()
            }
            counter > 0 -> {
                tvCounter.setTextColor(Color.GREEN)
                tvCounter.translationY = (counter * -1).toFloat()
            }
            else -> {
                tvCounter.setTextColor(Color.BLACK)
            }
        }
        tvCounter.text = counter.toString()
    }

    private fun countHandler(op: String) {
        when (op) {
            "-" -> counter--
            "+" -> counter++
        }
        changeTxt(counter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCounter = findViewById(R.id.counter)
        val plusBtn: Button = findViewById(R.id.plusBtn)
        val minusBtn: Button = findViewById(R.id.minusBtn)

        plusBtn.setOnClickListener { countHandler("+") }
        minusBtn.setOnClickListener { countHandler("-") }
    }
}