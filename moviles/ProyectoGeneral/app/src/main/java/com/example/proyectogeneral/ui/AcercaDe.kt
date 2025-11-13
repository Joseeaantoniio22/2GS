package com.example.proyectogeneral.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.CampingTheme
import com.example.proyectogeneral.R
import com.example.ui.theme.AppTypography

@Composable
fun AcercaDe(){
    val context = LocalContext.current;
    Column(
        verticalArrangement = Arrangement.spacedBy(
            40.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            style = AppTypography.displayLarge,
            text = context.getString(R.string.AcercaDe)
        )

        Image(
            painter = painterResource(id = R.drawable.acercade),
            contentDescription = "Acerca De",
            modifier = Modifier
                .clip(CircleShape)
                .size(250.dp)
        )

        Row {
            Card(
                modifier = Modifier.padding(20.dp)
            ) {
                Column (
                    modifier = Modifier
                        .padding(40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    Text(
                        style = AppTypography.titleMedium,
                        text = context.getString(R.string.InfoDev)
                    )
                    Spacer(Modifier.height(20.dp))
                    Text(
                        style = AppTypography.bodyLarge,
                        text = context.getString(R.string.Nombre)
                    )
                    Spacer(Modifier.height(20.dp))
                    Text(
                        style = AppTypography.bodyLarge,
                        text = context.getString(R.string.Correo)
                    )
                    Spacer(Modifier.height(20.dp))
                    Text(
                        style = AppTypography.bodyLarge,
                        text = context.getString(R.string.Portafolio)
                    )
                }
            }
        }

        Card(
            modifier = Modifier
                .padding(20.dp)
                .size(350.dp, 225.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    style = AppTypography.titleMedium,
                    text = context.getString(R.string.DatosApli)
                )
                Spacer(Modifier.height(15.dp))
                Text(
                    style = AppTypography.bodyLarge,
                    text = context.getString(R.string.Version)
                )
                Spacer(Modifier.height(15.dp))
                Text(
                    style = AppTypography.bodyLarge,
                    text = context.getString(R.string.NombreCamping)
                )
                Spacer(Modifier.height(15.dp))
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewAcercaDe() {
    CampingTheme {
        AcercaDe()
    }
}