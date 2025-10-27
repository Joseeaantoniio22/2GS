package com.example.actividad01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.actividad01.ui.AplicacionSencilla
import com.example.compose.Actividad01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Actividad01Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AplicacionSencilla(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


