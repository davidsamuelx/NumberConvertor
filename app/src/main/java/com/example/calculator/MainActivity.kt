package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var choice: RadioGroup
    private lateinit var etInput: EditText
    private lateinit var tvResult: TextView
    private lateinit var inputBaseChoice: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etInput = findViewById(R.id.etInput)
        tvResult = findViewById(R.id.tvResult)
        choice = findViewById(R.id.choice)
        inputBaseChoice = findViewById(R.id.inputchoice)

        choice.setOnCheckedChangeListener{ _, _ ->
            convert()
        }

        inputBaseChoice.setOnCheckedChangeListener { _, _ ->
            convert()
        }
    }

    private fun convert() {
        val inputNumber = etInput.text.toString()
        val fromBase = when (inputBaseChoice.checkedRadioButtonId) {
            R.id.inputRadioBin -> 2
            R.id.inputRadioOctal -> 8
            R.id.inputRadioDec -> 10
            R.id.inputRadioHex -> 16
            else -> return
        }
        val toBase = when (choice.checkedRadioButtonId) {
            R.id.radioBin -> 2
            R.id.radioOctal -> 8
            R.id.radioDec -> 10
            R.id.radioHex -> 16
            else -> return
        }
        try {
            val result = inputNumber.toLong(fromBase).toString(toBase)
            tvResult.text = result
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Invalid input number", Toast.LENGTH_SHORT).show()
        }
    }
}