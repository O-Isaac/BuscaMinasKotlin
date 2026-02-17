package com.github.isaac.buscaminaskotlin.components.tablero

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.isaac.buscaminaskotlin.R
import com.github.isaac.buscaminaskotlin.models.GameState

@Composable
fun Layout(state: GameState = viewModel()) {
    // Inicializar el tablero si es la primera vez
    LaunchedEffect(Unit) {
        state.reiniciarJuego()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Fondo del menú principal
        Image(
            painter = painterResource(R.drawable.fondo2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TableroTitulo(state)
            TableroGrid(state = state)
        }
    }
}
