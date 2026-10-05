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

@Preview()
@Composable
fun WorkoutTrackerScreen() {
    // TODO 1: estados
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
                // TODO 2: campo conectado a exerciseInput
                value = exerciseInput,
                onValueChange = { exerciseInput = it },
                label = { Text("Añadir movimiento (ej. Dominadas)") },
                modifier = Modifier.weight(1f)
            )

            FloatingActionButton(
                onClick = {
                    // TODO 3: añadir a la lista
                    if (exerciseInput.isNotBlank()) {
                        workoutList.add(exerciseInput.trim())
                        exerciseInput = ""
                    }
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "Añadir",
                    modifier = Modifier.size(32.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // LISTA DIFERIDA (RecyclerView de Compose)
        // TODO 4: lista falsa eliminada

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // TODO 5: usamos workoutList
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
                                // TODO 6: borrar el elemento
                                workoutList.remove(exercise)
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.delete_icon),
                                contentDescription = "Borrar",
                                tint = MaterialTheme.colorScheme.error,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}