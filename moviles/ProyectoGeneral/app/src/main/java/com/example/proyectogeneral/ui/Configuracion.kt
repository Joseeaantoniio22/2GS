package com.example.proyectogeneral.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectogeneral.R
import com.example.proyectogeneral.ui.datos.ConfiguracionCampingDataStore
import kotlinx.coroutines.launch

@Composable
fun ConfiguracionCampingScreen(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = ConfiguracionCampingDataStore(context)

    // Valores reales directamente desde DataStore (UNICA fuente de verdad)
    val admiteMascotas by dataStore.admiteMascotasFlow.collectAsState(false)
    val incluyeElectricidad by dataStore.incluyeElectricidadFlow.collectAsState(false)
    val notificaciones by dataStore.notificacionesFlow.collectAsState(false)

    val modoNocturno by dataStore.modoNocturnoFlow.collectAsState(false)
    val recordatorios by dataStore.recordReservasFlow.collectAsState(false)
    val localizacion by dataStore.localizacionFlow.collectAsState(false)

    val tipoParcela by dataStore.tipoParcelaFlow.collectAsState(context.getString(R.string.tipo_parcela))
    val temporada by dataStore.temporadaFlow.collectAsState(context.getString(R.string.temporada_baja))

    Column(modifier = Modifier.padding(20.dp)) {

        Text(text = context.getString(R.string.configuracion_camping), style = MaterialTheme.typography.titleLarge)

        Spacer(Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = admiteMascotas,
                onCheckedChange = { scope.launch { dataStore.setAdmiteMascotas(it) } }
            )
            Text(text = context.getString(R.string.admite_mascotas))
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = incluyeElectricidad,
                onCheckedChange = { scope.launch { dataStore.setIncluyeElectricidad(it) } }
            )
            Text(text = context.getString(R.string.incluye_electricidad))
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = notificaciones,
                onCheckedChange = { scope.launch { dataStore.setNotificaciones(it) } }
            )
            Text(text = context.getString(R.string.recibir_notificaciones))
        }

        Spacer(Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = modoNocturno,
                onCheckedChange = { scope.launch { dataStore.setModoNocturno(it) } }
            )
            Text(text = context.getString(R.string.modo_nocturno))
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = recordatorios,
                onCheckedChange = { scope.launch { dataStore.setRecordReservas(it) } }
            )
            Text(text = context.getString(R.string.recordatorio_reservas))
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = localizacion,
                onCheckedChange = { scope.launch { dataStore.setLocalizacion(it) } }
            )
            Text(text = context.getString(R.string.localizacion_camping))
        }

        Spacer(Modifier.height(20.dp))

        // RADIO BUTTONS --------------------------------------------------------
        Text(text = context.getString(R.string.tipo_parcela))

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = tipoParcela == context.getString(R.string.parcela_camping),
                onClick = { scope.launch { dataStore.setTipoParcela(context.getString(R.string.parcela_camping)) } }
            )
            Text(text = context.getString(R.string.parcela_camping))
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = tipoParcela == context.getString(R.string.parcela_caravana),
                onClick = { scope.launch { dataStore.setTipoParcela(context.getString(R.string.parcela_caravana)) } }
            )
            Text(text = context.getString(R.string.parcela_caravana))
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = tipoParcela == context.getString(R.string.parcela_autocaravana),
                onClick = { scope.launch { dataStore.setTipoParcela(context.getString(R.string.parcela_autocaravana)) } }
            )
            Text(text = context.getString(R.string.parcela_autocaravana))
        }

        Spacer(Modifier.height(20.dp))

        var expanded by remember { mutableStateOf(false) }

        Box {
            Button(onClick = { expanded = true }) {
                // Muestra la temporada actual con la primera letra en mayúscula
                Text(text = "${stringResource(R.string.temporada)} ${temporada.replaceFirstChar { it.uppercase() }}")
            }

            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.temporada_alta)) },
                    onClick = {
                        scope.launch { dataStore.setTemporada(context.getString(R.string.temporada_alta)) }
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.temporada_media)) },
                    onClick = {
                        scope.launch { dataStore.setTemporada(context.getString(R.string.temporada_media)) }
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.temporada_baja)) },
                    onClick = {
                        scope.launch { dataStore.setTemporada(context.getString(R.string.temporada_baja)) }
                        expanded = false
                    }
                )
            }
        }




        Spacer(Modifier.height(25.dp))

        // BOTÓN GUARDAR --------------------------------------------------------
        Button(
            onClick = {
                scope.launch {
                    dataStore.setAdmiteMascotas(admiteMascotas)
                    dataStore.setIncluyeElectricidad(incluyeElectricidad)
                    dataStore.setNotificaciones(notificaciones)

                    dataStore.setModoNocturno(modoNocturno)
                    dataStore.setRecordReservas(recordatorios)
                    dataStore.setLocalizacion(localizacion)

                    dataStore.setTipoParcela(tipoParcela)
                    dataStore.setTemporada(temporada)
                }
            }
        ) {
            Text(text = context.getString(R.string.guardar_configuracion))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConfiguracionCampingPreview() {
    MaterialTheme {
        CompositionLocalProvider(
            LocalContext provides androidx.compose.ui.platform.LocalContext.current
        ) {
            ConfiguracionCampingScreen()
        }
    }
}
