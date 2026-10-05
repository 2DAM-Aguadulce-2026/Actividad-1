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



@Preview(apiLevel = 33)
@Composable
fun WorkoutTrackerScreen() {
    // TODO 1: Crea las variables de estado
    // 1. Un estado 'exerciseInput' de tipo String para lo que el usuario escribe.
    var exerciseInput by remember { mutableStateOf("") }
    // 2. Un estado 'workoutList' que sea una lista reactiva.
    val workoutList = remember { mutableStateListOf<String>()}

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
                // TODO 2: Conecta este campo de texto con tu variable 'exerciseInput'
                value = exerciseInput, // Cambia esto
                onValueChange = { exerciseInput = it},
                label = { Text("Añadir movimiento (ej. Dominadas)") },
                modifier = Modifier.weight(1f)
            )

            FloatingActionButton(
                onClick = {
                    print("Hello")
                    // TODO 3: Lógica para añadir a la lista
                    // - Comprueba que 'exerciseInput' no esté vacío (puedes usar .isNotBlank())
                    // - Añade el texto a tu lista 'workoutList'
                    // - Vacía la variable 'exerciseInput' poniéndola a "" para que el campo se limpie
                    if (exerciseInput.isNotBlank()){
                        workoutList.add(exerciseInput.trim())
                        exerciseInput=""
                    }
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "Añadir",
                    modifier = Modifier.size(48.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // LISTA DIFERIDA (RecyclerView de Compose)

        // TODO 4: Borra esta lista falsa. Solo está aquí para que el código compile al principio.


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // TODO 5: Cambia 'listaFalsa' por tu variable 'workoutList'
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
                                // TODO 6: Lógica para borrar un elemento
                                // - Elimina el elemento 'exercise' de tu 'workoutList'
                                workoutList.remove(exercise)
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.delete_icon),
                                contentDescription = "Borrar",
                                tint = MaterialTheme.colorScheme.error,
                                modifier = Modifier.size(48.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}