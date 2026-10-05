package com.aguadulce.practica1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun WorkoutTrackerScreen() {
    // ESTADO: Los alumnos deben manejar un String simple y una lista mutable
    var exerciseInput by remember { mutableStateOf("") }
    val workoutList = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "WOD Tracker",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp, top = 16.dp)
        )

        // FILA SUPERIOR: Input + Botón Añadir
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = exerciseInput,
                onValueChange = { exerciseInput = it },
                label = { Text("Añadir movimiento (ej. Dominadas)") },
                modifier = Modifier.weight(1f) // Ocupa el espacio disponible
            )

            FloatingActionButton(
                onClick = {
                    // LÓGICA DE AÑADIR
                    if (exerciseInput.isNotBlank()) {
                        workoutList.add(exerciseInput)
                        exerciseInput = "" // Limpiar el campo
                    }
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.add_icon), 
                    contentDescription = "Añadir",
                    modifier = Modifier.size(32.dp) // Aumentamos el tamaño del icono
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // LISTA DIFERIDA: Lo que los alumnos deben enlazar con la lista de estado
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(workoutList) { exercise ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = exercise, fontSize = 18.sp)

                        IconButton(
                            onClick = {
                                // LÓGICA DE BORRAR
                                workoutList.remove(exercise)
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.delete_icon),
                                contentDescription = "Borrar",
                                tint = MaterialTheme.colorScheme.error,
                                modifier = Modifier.size(28.dp) // Aumentamos el tamaño del icono
                            )
                        }
                    }
                }
            }
        }
    }
}