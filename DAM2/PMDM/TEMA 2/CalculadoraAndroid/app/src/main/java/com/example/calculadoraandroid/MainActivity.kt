package com.example.calculadoraandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.calculadoraandroid.databinding.ActivityMainBinding
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Variables para la calculadora
    private var numero1: Double = 0.0
    private var numero2: Double = 0.0
    private var operacion: String = ""
    private var pantallaTexto: String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initGUI()
        acciones()
    }

    private fun initGUI() {
        binding.pantalla.text = pantallaTexto
    }

    private fun acciones() {
        // Botones numéricos
        binding.boton0.setOnClickListener { agregarNumero("0") }
        binding.boton1.setOnClickListener { agregarNumero("1") }
        binding.boton2.setOnClickListener { agregarNumero("2") }
        binding.boton3.setOnClickListener { agregarNumero("3") }
        binding.boton4.setOnClickListener { agregarNumero("4") }
        binding.boton5.setOnClickListener { agregarNumero("5") }
        binding.boton6.setOnClickListener { agregarNumero("6") }
        binding.boton7.setOnClickListener { agregarNumero("7") }
        binding.boton8.setOnClickListener { agregarNumero("8") }
        binding.boton9.setOnClickListener { agregarNumero("9") }

        // Operaciones básicas
        binding.botonSumar.setOnClickListener { prepararOperacion("+") }
        binding.botonRestar.setOnClickListener { prepararOperacion("-") }
        binding.botonMultiplicar.setOnClickListener { prepararOperacion("×") }
        binding.botonDividir.setOnClickListener { prepararOperacion("/") }
        binding.botonIgual.setOnClickListener { calcularResultado() }

        // Botones especiales
        binding.botonPunto.setOnClickListener { agregarPunto() }
        binding.botonLimpiar.setOnClickListener { limpiarTodo() }
        binding.botonBorrar.setOnClickListener { borrarUltimo() }

        // Botones científicos - BUSCARLOS MANUALMENTE
        configurarBotonesCientificos()
    }

    private fun configurarBotonesCientificos() {
        // Buscar los botones científicos manualmente
        // Usamos try-catch por si no existen en el layout actual

        try {
            val botonSin: Button = findViewById(R.id.botonSin)
            botonSin.setOnClickListener { funcionCientifica("sin") }
        } catch (e: Exception) { }

        try {
            val botonCos: Button = findViewById(R.id.botonCos)
            botonCos.setOnClickListener { funcionCientifica("cos") }
        } catch (e: Exception) { }

        try {
            val botonTan: Button = findViewById(R.id.botonTan)
            botonTan.setOnClickListener { funcionCientifica("tan") }
        } catch (e: Exception) { }

        try {
            val botonRaiz: Button = findViewById(R.id.botonRaiz)
            botonRaiz.setOnClickListener { funcionCientifica("raiz") }
        } catch (e: Exception) { }

        try {
            val botonPotencia: Button = findViewById(R.id.botonPotencia)
            botonPotencia.setOnClickListener { funcionCientifica("potencia") }
        } catch (e: Exception) { }

        try {
            val botonPi: Button = findViewById(R.id.botonPi)
            botonPi.setOnClickListener { funcionCientifica("pi") }
        } catch (e: Exception) { }

        try {
            val botonLog: Button = findViewById(R.id.botonLog)
            botonLog.setOnClickListener { funcionCientifica("log") }
        } catch (e: Exception) { }

        try {
            val botonLn: Button = findViewById(R.id.botonLn)
            botonLn.setOnClickListener { funcionCientifica("ln") }
        } catch (e: Exception) { }

        try {
            val botonFactorial: Button = findViewById(R.id.botonFactorial)
            botonFactorial.setOnClickListener { funcionCientifica("factorial") }
        } catch (e: Exception) { }
    }

    // MÉTODOS PARA LA CALCULADORA

    private fun agregarNumero(numero: String) {
        if (pantallaTexto == "0" || pantallaTexto == "Error") {
            pantallaTexto = numero
        } else {
            pantallaTexto += numero
        }
        actualizarPantalla()
    }

    private fun prepararOperacion(op: String) {
        if (pantallaTexto.isNotEmpty() && pantallaTexto != "Error") {
            numero1 = pantallaTexto.toDouble()
            operacion = op
            pantallaTexto = "0"
            actualizarPantalla()
        }
    }

    private fun calcularResultado() {
        if (operacion.isNotEmpty() && pantallaTexto != "Error") {
            try {
                numero2 = pantallaTexto.toDouble()
                val resultado = when (operacion) {
                    "+" -> numero1 + numero2
                    "-" -> numero1 - numero2
                    "×" -> numero1 * numero2
                    "/" -> {
                        if (numero2 != 0.0) {
                            numero1 / numero2
                        } else {
                            throw ArithmeticException("División por cero")
                        }
                    }
                    else -> 0.0
                }
                mostrarResultado(resultado)
                operacion = ""
            } catch (e: Exception) {
                pantallaTexto = "Error"
                actualizarPantalla()
            }
        }
    }

    private fun funcionCientifica(funcion: String) {
        if (pantallaTexto != "Error") {
            try {
                val valor = pantallaTexto.toDouble()
                val resultado = when (funcion) {
                    "sin" -> sin(Math.toRadians(valor))
                    "cos" -> cos(Math.toRadians(valor))
                    "tan" -> tan(Math.toRadians(valor))
                    "raiz" -> sqrt(valor)
                    "potencia" -> valor * valor
                    "pi" -> Math.PI
                    "log" -> log10(valor)
                    "ln" -> ln(valor)
                    "factorial" -> factorial(valor.toInt()).toDouble()
                    else -> valor
                }

                if (resultado.isNaN() || resultado.isInfinite()) {
                    pantallaTexto = "Error"
                } else {
                    // Formatear el resultado
                    pantallaTexto = if (resultado % 1 == 0.0) {
                        resultado.toInt().toString()
                    } else {
                        // Mostrar máximo 6 decimales
                        String.format("%.6f", resultado).removeSuffix("0").removeSuffix("0").removeSuffix("0").removeSuffix(".")
                    }
                }
                actualizarPantalla()
            } catch (e: Exception) {
                pantallaTexto = "Error"
                actualizarPantalla()
            }
        }
    }

    private fun factorial(n: Int): Long {
        return if (n <= 1) 1 else n * factorial(n - 1)
    }

    private fun agregarPunto() {
        if (!pantallaTexto.contains(".")) {
            pantallaTexto += "."
            actualizarPantalla()
        }
    }

    private fun limpiarTodo() {
        pantallaTexto = "0"
        numero1 = 0.0
        numero2 = 0.0
        operacion = ""
        actualizarPantalla()
    }

    private fun borrarUltimo() {
        if (pantallaTexto.length > 1) {
            pantallaTexto = pantallaTexto.substring(0, pantallaTexto.length - 1)
        } else {
            pantallaTexto = "0"
        }
        actualizarPantalla()
    }

    private fun mostrarResultado(resultado: Double) {
        pantallaTexto = if (resultado % 1 == 0.0) {
            resultado.toInt().toString()
        } else {
            String.format("%.6f", resultado).removeSuffix("0").removeSuffix("0").removeSuffix("0").removeSuffix(".")
        }
        actualizarPantalla()
    }

    private fun actualizarPantalla() {
        binding.pantalla.text = pantallaTexto
    }
}