package com.example.proyectomovil

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        probarFirebase()

        setContent {
            // Aquí usamos el tema por defecto de tu proyecto
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                SaludoInicial("Illo, la base de datos está conectando...")
            }
        }
    }

    private fun probarFirebase() {
        val db = FirebaseFirestore.getInstance()

        // Creamos un mapa de datos para probar
        val prueba = hashMapOf(
            "negocio" to "Illo Camperos",
            "mensaje" to "Si ves esto, Firebase está bien enlazado",
            "fecha" to System.currentTimeMillis()
        )

        // Intentamos guardar en una colección llamada "test_conexion"
        db.collection("test_conexion")
            .add(prueba)
            .addOnSuccessListener { documentReference ->
                Log.d("FIREBASE_OK", "¡Funciona! ID del doc: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.e("FIREBASE_ERROR", "Vaya... algo ha fallado", e)
            }
    }
}

@Composable
fun SaludoInicial(mensaje: String) {
    Text(
        text = mensaje,
        modifier = Modifier.padding(24.dp),
        style = MaterialTheme.typography.headlineMedium
    )
}