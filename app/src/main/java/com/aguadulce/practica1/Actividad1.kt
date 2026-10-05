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
    // 1. Variable para guardar el texto que escribe el usuario (empieza vacía)
    var inputAmount by remember { mutableStateOf("") }

    // 2. Variable para el mensaje de resultado
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
            value = "$inputAmount", // Cambia esto
            onValueChange = { inputAmount = it },
            label = { Text("Cantidad de Mineral") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),//Completa aquí,
            modifier = Modifier.fillMaxWidth()
        )

        // BOTÓN Y LÓGICA
        Button(
            onClick = {
                // TODO 3: Programa la lógica de la calculadora
                val numero = inputAmount.toIntOrNull()
                if (numero != null) {
                    val pepitas = numero * 9
                    resultText = "El número de pepitas que has conseguido es $pepitas"
                } else {
                    resultText = "Error, valor no válido"
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
                text = "Resultado: $resultText",
                modifier = Modifier.padding(16.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}