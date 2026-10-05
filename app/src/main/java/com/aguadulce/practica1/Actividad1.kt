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

private const val PROPORCION = 1.15

@Preview(showBackground = true)
@Composable
fun show() {
    FactoryCalculatorScreen()
}

@Composable
fun FactoryCalculatorScreen() {
    // TODO 1: Crea dos variables de estado usando remember { mutableStateOf(...) }
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

        // TODO 2: Conecta 'value' a tu variable 'inputAmount' y actualízala en 'onValueChange'
        OutlinedTextField(
            value = inputAmount,
            onValueChange = { inputAmount = it },
            label = { Text("Cantidad de Mineral") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                // TODO 3: Programa la lógica de la calculadora
                val numero = inputAmount.toDoubleOrNull()
                resultText = if (numero != null) {
                    val resultado = numero * PROPORCION
                    "Con $numero de mineral obtienes ${"%.2f".format(resultado)} lingotes"
                } else {
                    "Error: introduce una cantidad válida"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Procesar")
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            // TODO 4: Muestra aquí el valor de tu variable 'resultText'
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