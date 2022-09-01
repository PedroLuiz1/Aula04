package com.example.aula04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import com.example.aula04.databinding.ActivityTemperaturaBinding
//import kotlinx.android.synthetic.main.activity_temperatura.*

class TemperaturaActivity : AppCompatActivity() {

    lateinit var binding: ActivityTemperaturaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemperaturaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Tipo de binding: findViewById
        /*val editValor: EditText = findViewById(R.id.editValor)
        val editResult: EditText = findViewById(R.id.editResult)
        val buttonConverter: Button = findViewById(R.id.buttonConverter)
        val grupoTemperatura: RadioGroup = findViewById(R.id.grupoTemperatura)*/

        binding.buttonConverter.setOnClickListener {
            if (binding.editValor.text.isNotEmpty()) {
                val valor = binding.editValor.text.toString().toFloat()

                when(binding.grupoTemperatura.checkedRadioButtonId) {
                    R.id.radioKelvin -> {
                        val resultado = valor + 273
                        binding.editResult.setText(resultado.toString())
                    }
                    R.id.radioFahrenheit -> {
                        val resultado = valor * 1.8 + 32
                        binding.editResult.setText(resultado.toString())
                    }
                    else -> {
                        binding.editResult.setText("Selecione uma temperatura")
                    }
                }

            } else {
                binding.editResult.setText("Digite um valor de temperatura")
            }
        }


    }
}