package com.example.proyectogeneral

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.compose.CampingTheme
import com.example.proyectogeneral.ui.CampingMain

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CampingTheme{
                        CampingMain(modifier = Modifier.padding(innerPadding));
                    }
                }
            }
        }
    }
}
