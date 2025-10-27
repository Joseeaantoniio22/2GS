package com.example.actividad01.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.actividad01.R
import com.example.actividad01.ui.theme.misFormas
import com.example.compose.Actividad01Theme

@Composable
fun AplicacionSencilla(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var texto by remember { mutableStateOf(context.getString(R.string.textoMain)) }
    var pulsarBoton by remember { mutableStateOf(true) }
    var resetearBoton by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        LazyRow {
            items(10) { index ->
                Card(
                    shape = misFormas.medium,
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    modifier = Modifier.padding(16.dp)
                        .size(160.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = context.getString(R.string.textoTarjeta)+" $index",
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
        }
        Row {
            Text(text = texto,
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Button(
                onClick = {
                    texto = context.getString(R.string.textoPulsado)
                    pulsarBoton = false
                    resetearBoton = true
                },
                enabled = pulsarBoton
            ) {
                Text(context.getString(R.string.botonPulsado))
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    texto = context.getString(R.string.textoMain)
                    pulsarBoton = true
                    resetearBoton = false
                },
                enabled = resetearBoton
            ) {
                Text(text = context.getString(R.string.botonReseteado))
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, backgroundColor = 0xFF000000)
@Composable
fun Actividad01Preview(){
    Actividad01Theme {
        AplicacionSencilla()
    }
}


