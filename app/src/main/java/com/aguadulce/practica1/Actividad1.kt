
package dam.pmdm.actividad01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




@Composable
fun FactoryCalculatorScreen(
    modifier: Modifier = Modifier
) {

    // ESTADOS
    var inputAmount by remember {
        mutableStateOf("")
    }

    var resultText by remember {
        mutableStateOf("Esperando datos...")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // TÍTULO
        Text(
            text = "Optimizador de Fábrica",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )

        // ENTRADA DE DATOS
        OutlinedTextField(
            value = inputAmount,
            onValueChange = {
                inputAmount = it
            },
            label = {
                Text("Cantidad de Mineral")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // BOTÓN Y LÓGICA
        Button(
            onClick = {

                // Convertimos el texto a número
                val amount = inputAmount.toDoubleOrNull()

                if (amount != null) {

                    // Proporción de producción
                    val result = amount * 0.8

                    resultText = "Resultado: $result pepitas"

                } else {

                    resultText = "Error: introduce una cantidad válida"
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
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {

            Text(
                text = resultText,
                modifier = Modifier.padding(16.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

