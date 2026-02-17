package com.github.isaac.buscaminaskotlin.components.tablero

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.isaac.buscaminaskotlin.models.GameState

@Composable
fun Layout(state: GameState = viewModel()) {
    // Inicializar el tablero si es la primera vez (o podrías hacerlo en el init del ViewModel)
    LaunchedEffect(Unit) {
        state.reiniciarJuego()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TableroTitulo(state)
        TableroGrid(state = state)
    }
}