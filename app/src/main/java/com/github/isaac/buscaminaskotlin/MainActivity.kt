package com.github.isaac.buscaminaskotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.github.isaac.buscaminaskotlin.components.tablero.Layout
import com.github.isaac.buscaminaskotlin.ui.theme.BuscaMinasKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuscaMinasKotlinTheme {
                Layout()
            }
        }
    }
}

