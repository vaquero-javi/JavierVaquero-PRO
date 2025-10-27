package com.example.tablasdemultiplicar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.example.tablasdemultiplicar.ui.theme.TablasDeMultiplicarTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.animation.animateContentSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TablasDeMultiplicarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    var resultado by remember { mutableStateOf(TextFieldValue()) }

    // Fondo degradado dinámico
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFBBDEFB), Color(0xFFE3F2FD))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize() // animación al cambiar tamaño
        ) {
            Button(
                onClick = { resultado = tablamulti() },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .height(60.dp)
                    .width(250.dp)
            ) {
                Text("Hacer tablas de multiplicar", style = MaterialTheme.typography.titleMedium, color = Color.White)
            }

            if (resultado.text.isNotEmpty()) {
                TextField(
                    value = resultado,
                    onValueChange = { },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 200.dp, max = 400.dp)
                        .background(
                            color = MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(8.dp)
                )
            }
        }
    }
}

private fun tablamulti(): TextFieldValue {
    return runBlocking {
        val tablaInicio = 1
        val tablaFin = 10

        val deferredList = (tablaInicio..tablaFin).map { tabla ->
            async(Dispatchers.Default) {
                buildString {
                    append("Tabla del $tabla:\n")
                    for (i in 1..10) {
                        append("$tabla x $i = ${tabla * i}\n")
                        delay(50) // más rápido para animación más fluida
                    }
                    append("Tabla del $tabla completada\n")
                }
            }
        }

        val resultList = deferredList.awaitAll()
        TextFieldValue(text = resultList.joinToString("\n"))
    }
}
