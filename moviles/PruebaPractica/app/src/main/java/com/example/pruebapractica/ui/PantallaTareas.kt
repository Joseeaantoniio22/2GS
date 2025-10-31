package com.example.pruebapractica.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebapractica.R
import com.example.ui.theme.AppTypography

@Composable
fun PantallaTareas(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    val estadosTareas = remember { mutableStateListOf(false, false, false, false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = context.getString(R.string.Titulo),
            style = AppTypography.displayLarge
        )

        LazyColumn(
            modifier = Modifier.width(300.dp)
        ) {
            val tareas = listOf(
                context.getString(R.string.tarea1),
                context.getString(R.string.tarea2),
                context.getString(R.string.tarea3),
                context.getString(R.string.tarea4)


            )
            items(tareas.indices.toList()) { index ->
                Spacer(Modifier.height(20.dp))

                Card(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = tareas[index],
                            style = if (estadosTareas[index] == true)
                                TextStyle(textDecoration = TextDecoration.LineThrough)
                            else
                                TextStyle(),
                        )
                        Checkbox(
                            checked = estadosTareas[index],
                            onCheckedChange = { estadosTareas[index] = it },
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "Examen", showBackground = true)
@Composable
fun ExamenPreview(){
    PantallaTareas()
}
