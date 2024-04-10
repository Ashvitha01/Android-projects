package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculate.setOnClickListener {
            CalculateBMI()
        }
    }

    private fun CalculateBMI(){
        val weight = binding.weightTextEdit.text.toString().toFloatOrNull()
        val height = binding.heightTextEdit.text.toString().toFloatOrNull()

        if(weight!=null && height!=null){
            val bmi = weight/ (height/100).pow(2)
            val bmiResult = String.format("%.2f", bmi)

            val bmicategory = when {
                bmi < 18.5 -> "Underweight"
                bmi < 25 -> "Normal weight"
                bmi < 30 -> "Over weight"
                else -> "obese"
            }
            binding.resultText.text = "BMI: $bmiResult\ncategory: $bmicategory"
        }
        else{
            binding.resultText.text = "Invalid Input"
        }
    }
}