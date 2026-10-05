package com.aguadulce.practica1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview (showBackground = true)
@Composable
fun show(){
    FactoryCalculatorScreen()
}

@Composable
fun FactoryCalculatorScreen() {
    // TODO 1: Crea dos variables de estado usando remember { mutableStateOf(...) }
    // 1. Una variable llamada 'inputAmount' para guardar lo que escribe el usuario
    // 2. Una variable llamada 'resultText' para el mensaje de abajo (empieza como "Esperando datos...")

    var inputAmount by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("Esperando datos...") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Optimizador de Fábrica",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )

        // ENTRADA DE DATOS
        OutlinedTextField(
            // TODO 2: Conecta 'value' a tu variable 'inputAmount' y actualízala en 'onValueChange'
            value = inputAmount, // Cambia esto
            onValueChange = { inputAmount = it },
            label = { Text("Cantidad de Mineral") },
            // keyboardOptions = //Completa aquí,
            modifier = Modifier.fillMaxWidth()
        )

        // BOTÓN Y LÓGICA
        Button(
            onClick = {
                // TODO 3: Programa la lógica de la calculadora
                // PISTAS:
                // - Convierte tu variable 'inputAmount' a número.
                // - Si el número NO es nulo, multiplícalo por (piensa en la proporción) y guarda el mensaje en 'resultText'.
                // - Si el número ES nulo (el campo estaba vacío), guarda en 'resultText' un mensaje de Error.
                val cantidad = inputAmount.toIntOrNull()

                if(cantidad != null){
                    val result = cantidad * 9

                    resultText = "Tendrías $result pepitas."

                } else {
                    resultText = "Error: La cantidad introducida no es valida o esta vacia."
                }

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Procesar")
        }

        // RESULTADO VISUAL
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            // TODO 4: Muestra aquí el valor de tu variable 'resultText'
            // Crea un text con un padding, un tam de fuente, un color y un fontweight. (Que no se te olvide poner Resultado)
            Text(
                text = resultText, // Cambia esto
                modifier = Modifier.padding(16.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}