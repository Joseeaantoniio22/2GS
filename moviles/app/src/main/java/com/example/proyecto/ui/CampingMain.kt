package com.example.proyecto.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.proyecto.R

@Composable
fun CampingMain(modifier: Modifier){
    val context = LocalContext.current;
    Column(
        verticalArrangement = Arrangement.spacedBy(
            20.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = context.getString(R.string.Bienvenida)
        )

        Image(
            painter = painterResource(id = R.drawable.inicio),
            contentDescription = "Imagen de inicio",
            modifier = Modifier
                .clip(CircleShape)
                .size(300.dp)
        )

        Card {
            Text(
                text = context.getString(R.string.BotonNosotros)
            )
        }

        Card {
            Text(
                text = context.getString(R.string.historia)
            )
        }

        Card {
            Text(
                text = context.getString(R.string.AcercaDe)
            )
        }

        Card {
            Text(
                text = context.getString(R.string.Ayuda)
            )
        }
    }
}



