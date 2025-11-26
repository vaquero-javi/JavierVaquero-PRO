package com.example.imcandoid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imcandoid.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    // Binding
   lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        binding.buttonCalcular.setOnClickListener {
            calcularIMC()
        }
    }

    private fun calcularIMC() {
        val pesoText = binding.editTextPeso.text.toString()
        val alturaText = binding.editTextAltura.text.toString()

        // Verificar si se seleccionó un sexo
        val sexoSeleccionado = when {
            binding.radioHombre.isChecked -> "H"
            binding.radioMujer.isChecked -> "F"
            else -> ""
        }

        if (sexoSeleccionado.isEmpty()) {
            mostrarError("Seleccione su sexo")
            return
        }

        // Verificar que los campos no estén vacíos
        if (pesoText.isEmpty() || alturaText.isEmpty()) {
            mostrarError("Complete todos los campos")
            return
        }

        // Convertir a números
        val peso = pesoText.toDoubleOrNull()
        val altura = alturaText.toDoubleOrNull()

        if (peso == null || altura == null) {
            mostrarError("Ingrese números válidos")
            return
        }

        if (peso <= 0 || altura <= 0) {
            mostrarError("Los valores deben ser mayores a 0")
            return
        }

        // Calcular IMC
        val imc = peso / (altura * altura)

        // Ir a la segunda pantalla
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("IMC", imc)
        intent.putExtra("SEXO", sexoSeleccionado)
        startActivity(intent)
    }

    private fun mostrarError(mensaje: String) {
        Snackbar.make(binding.buttonCalcular, mensaje, Snackbar.LENGTH_LONG).show()
    }
}