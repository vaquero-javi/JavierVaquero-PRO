package com.example.imcandoid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imcandoid.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    // Binding
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar binding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mostrarResultado()
        acciones()
    }

    private fun mostrarResultado() {
        val imc = intent.getDoubleExtra("IMC", 0.0)
        val sexo = intent.getStringExtra("SEXO") ?: "H"

        // Mostrar IMC con un decimal
        binding.textViewIMC.text = String.format("%.1f", imc)

        // Determinar estado y imagen
        val resultado = calcularEstado(imc, sexo)
        binding.textViewEstado.text = resultado.first

        // Cambiar color según el estado
        val colorFondo = when (resultado.second) {
            1 -> android.R.color.holo_orange_light  // Bajo peso
            2 -> android.R.color.holo_green_light   // Normal
            3 -> android.R.color.holo_orange_light  // Sobrepeso
            else -> android.R.color.holo_red_light  // Obesidad
        }
        binding.textViewEstado.setBackgroundColor(getColor(colorFondo))

        // Asignar imagen
        val imagenId = when (resultado.third) {
            1 -> R.drawable.estado1
            2 -> R.drawable.estado2
            3 -> R.drawable.estado3
            4 -> R.drawable.estado4
            5 -> R.drawable.estado5
            6 -> R.drawable.estado6
            else -> R.drawable.estado1
        }
        binding.imageViewEstado.setImageResource(imagenId)
    }

    private fun acciones() {
        binding.buttonVolver.setOnClickListener {
            finish()
        }
    }

    private fun calcularEstado(imc: Double, sexo: String): Triple<String, Int, Int> {
        return if (sexo == "H") {
            // Hombre
            when {
                imc < 18.5 -> Triple("Bajo peso", 1, 1)
                imc < 25.0 -> Triple("Peso normal", 2, 2)
                imc < 30.0 -> Triple("Sobrepeso", 3, 3)
                imc < 35.0 -> Triple("Obesidad I", 4, 4)
                imc < 40.0 -> Triple("Obesidad II", 4, 5)
                else -> Triple("Obesidad III", 4, 6)
            }
        } else {
            // Mujer
            when {
                imc < 16.5 -> Triple("Bajo peso", 1, 1)
                imc < 23.0 -> Triple("Peso normal", 2, 2)
                imc < 26.0 -> Triple("Sobrepeso", 3, 3)
                imc < 31.0 -> Triple("Obesidad I", 4, 4)
                imc < 34.0 -> Triple("Obesidad II", 4, 5)
                else -> Triple("Obesidad III", 4, 6)
            }
        }
    }
}