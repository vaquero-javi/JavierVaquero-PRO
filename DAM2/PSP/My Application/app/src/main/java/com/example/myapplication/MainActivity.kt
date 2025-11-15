package com.example.myapplication

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.net.Socket
import java.util.concurrent.Executors

class MainActivity : ComponentActivity() {
    private lateinit var sensorManager: SensorManager
    private val networkExecutor = Executors.newSingleThreadExecutor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ControlPanel()
                }
            }
        }

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        registerAccelerometerListener()
    }

    private fun registerAccelerometerListener() {
        val accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val accelerometerListener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent) {
                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]

                val direction = determineDirection(x, y, z)
                if (direction != "quieto") {
                    sendDirectionToServer(direction)
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                // No es relevante para este ejemplo
            }
        }

        sensorManager.registerListener(
            accelerometerListener,
            accelerometerSensor,
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    private fun determineDirection(x: Float, y: Float, z: Float): String {
        return when {
            x > 2 -> "izquierda"
            x < -2 -> "derecha"
            y > 2 -> "abajo"
            y < -2 -> "arriba"
            else -> "quieto"
        }
    }

    fun sendDirectionToServer(direction: String) {
        networkExecutor.execute {
            val host = "172.20.10.6" // IP del servidor
            val puerto = 6000

            try {
                val cliente = Socket(host, puerto)
                val outputStream = cliente.getOutputStream()
                val mensaje = "$direction\n" // Agregar newline para readLine() del servidor
                outputStream.write(mensaje.toByteArray())
                outputStream.flush()
                cliente.close()

                runOnUiThread {
                    Toast.makeText(this@MainActivity, "Movimiento: $direction", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                runOnUiThread {
                    Toast.makeText(this@MainActivity, "Error de conexión", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        networkExecutor.shutdown()
    }
}

@Composable
fun ControlPanel() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "🖱️ Control Remoto de Ratón",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Text(
            text = "Inclina el dispositivo para mover el ratón",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Indicadores de dirección
        DirectionIndicator("⬅️ Izquierda", "Inclina a la izquierda")
        DirectionIndicator("➡️ Derecha", "Inclina a la derecha")
        DirectionIndicator("⬆️ Arriba", "Inclina hacia arriba")
        DirectionIndicator("⬇️ Abajo", "Inclina hacia abajo")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                (context as? MainActivity)?.sendDirectionToServer("click")
            },
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text("🖱️ Hacer Click")
        }
    }
}

@Composable
fun DirectionIndicator(icon: String, description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "$icon $description",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}