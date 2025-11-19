package com.example.proyectogeneral.ui.datos

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ConfiguracionCampingDataStore(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("config_camping")

        // Checkbox
        val ADMITE_MASCOTAS = booleanPreferencesKey("adm_mascotas")
        val INCLUYE_ELECTRICIDAD = booleanPreferencesKey("incluye_elec")
        val NOTIFICACIONES = booleanPreferencesKey("notif")

        // Switch
        val MODO_NOCTURNO = booleanPreferencesKey("modo_nocturno")
        val RECORDATORIO_RESERVAS = booleanPreferencesKey("record_reservas")
        val LOCALIZACION = booleanPreferencesKey("localizacion")

        // RadioButton
        val TIPO_PARCELA = stringPreferencesKey("tipo_parcela")

        // Dropdown
        val TEMPORADA = stringPreferencesKey("temporada")
    }

    // Flujos (lectura)
    val admiteMascotasFlow: Flow<Boolean> = context.dataStore.data.map { it[ADMITE_MASCOTAS] ?: false }
    val incluyeElectricidadFlow: Flow<Boolean> = context.dataStore.data.map { it[INCLUYE_ELECTRICIDAD] ?: false }
    val notificacionesFlow: Flow<Boolean> = context.dataStore.data.map { it[NOTIFICACIONES] ?: false }

    val modoNocturnoFlow: Flow<Boolean> = context.dataStore.data.map { it[MODO_NOCTURNO] ?: false }
    val recordReservasFlow: Flow<Boolean> = context.dataStore.data.map { it[RECORDATORIO_RESERVAS] ?: false }
    val localizacionFlow: Flow<Boolean> = context.dataStore.data.map { it[LOCALIZACION] ?: false }

    val tipoParcelaFlow: Flow<String> = context.dataStore.data.map { it[TIPO_PARCELA] ?: "camping" }

    val temporadaFlow: Flow<String> = context.dataStore.data.map { it[TEMPORADA] ?: "baja" }

    // Escritura
    suspend fun setAdmiteMascotas(value: Boolean) = context.dataStore.edit { it[ADMITE_MASCOTAS] = value }
    suspend fun setIncluyeElectricidad(value: Boolean) = context.dataStore.edit { it[INCLUYE_ELECTRICIDAD] = value }
    suspend fun setNotificaciones(value: Boolean) = context.dataStore.edit { it[NOTIFICACIONES] = value }

    suspend fun setModoNocturno(value: Boolean) = context.dataStore.edit { it[MODO_NOCTURNO] = value }
    suspend fun setRecordReservas(value: Boolean) = context.dataStore.edit { it[RECORDATORIO_RESERVAS] = value }
    suspend fun setLocalizacion(value: Boolean) = context.dataStore.edit { it[LOCALIZACION] = value }

    suspend fun setTipoParcela(value: String) = context.dataStore.edit { it[TIPO_PARCELA] = value }
    suspend fun setTemporada(value: String) = context.dataStore.edit { it[TEMPORADA] = value }
}
