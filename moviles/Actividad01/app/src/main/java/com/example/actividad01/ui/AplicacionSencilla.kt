package com.example.actividad01.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.actividad01.ui.theme.Actividad01Theme

@Composable
fun AplicacionSencilla(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(70.dp))
        LazyRow {
            items(10) { index ->
                Card(
                    shape = RoundedCornerShape(15.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Tarjeta Nª$index",
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
        // Estado del texto que se muestra
        var texto by remember { mutableStateOf("Nadie pulsó el botón aún") }
        // Estado del botón Pulsar habilitado/deshabilitado
        var pulsarBoton by remember { mutableStateOf(true) }
        // Estado del botón Resetear habilitado/deshabilitado
        var resetearBoton by remember { mutableStateOf(false) }
        Row {
            Text(text = texto)
        }

        Row {
            Button(
                onClick = {
                    texto = "Jose Antonio Fernández pulsó el botón"
                    pulsarBoton = false
                    resetearBoton = true
                },
                enabled = pulsarBoton
            ) {
                Text("Pulsar")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    texto = "Nadie pulsó el botón aún"
                    pulsarBoton = true
                    resetearBoton = false
                },
                enabled = resetearBoton
            ) {
                Text("Resetear")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AplicacionSencillaPreview() {
    Actividad01Theme {
        AplicacionSencilla("Android")
    }
}