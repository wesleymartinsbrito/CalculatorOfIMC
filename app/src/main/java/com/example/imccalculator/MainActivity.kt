package com.example.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //peso / altura*altura
        btnCalculator.setOnClickListener {
            var peso = personWeight.getText().toString().toDouble()
            var altura = personHeight.getText().toString().toDouble()
            var result = peso / (altura * altura)
            var resultNumber = result.toDouble()

            tvResult.text = "Seu IMC é: $result"

            if (resultNumber <= 18.5) {
                resultAbout.text = "VOCÊ ESTÁ ABAIXO DO PESO!"
            } else if (resultNumber in 18.6..24.9) {
                resultAbout.text = "VOCÊ ESTÁ NO PESO IDEAL!"
            } else if (resultNumber in 25.0..29.9) {
                resultAbout.text = "LEVEMENTE ACIMA DO PESO!"
            } else if (resultNumber in 30.0..34.9) {
                resultAbout.text = "OBESIDADE GRAU I"
            } else if (resultNumber in 35.0..39.9) {
                resultAbout.text = "OBESIDADE GRAU II (SEVERA)"
            } else {
                resultAbout.text = "OBESIDADE GRAU III (MÓRBIDA)"
            }
        }

        btnClean.setOnClickListener{
            resultAbout.text = ""
            tvResult.text = ""
        }
    }
}