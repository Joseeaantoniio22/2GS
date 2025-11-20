package com.example.proyectogeneral.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun SobreNosotros(){
    val context = LocalContext.current;
    Column(
        verticalArrangement = Arrangement.spacedBy(
            20.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = context.getString(R.string.BotonNosotros),
            style = AppTypography.displayLarge
        )

        Image(
            painter = painterResource(id = R.drawable.nosotros2),
            contentDescription = "Imagen de inicio",
            modifier = Modifier
                .clip(CircleShape)
                .size(250.dp)
        )

        Card (
            modifier = Modifier.padding(40.dp)
        ) {
            Text(
                modifier = Modifier.padding(20.dp),
                text = context.getString(R.string.textoNosotros)
            )
        }

        Card (
            modifier = Modifier.padding(40.dp)
        ) {
            Text(
                modifier = Modifier.padding(20.dp),
                text = context.getString(R.string.textoNosotros)
            )
        }

    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewSobreNosotros() {
    CampingTheme {
        SobreNosotros()
    }
}