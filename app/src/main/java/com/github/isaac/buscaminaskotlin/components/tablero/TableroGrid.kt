package com.github.isaac.buscaminaskotlin.components.tablero

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.isaac.buscaminaskotlin.models.GameState

@Composable
fun TableroGrid(modifier: Modifier = Modifier, state: GameState = viewModel()) {
    val config = state.config
    val tablero = state.tablero

    LazyVerticalGrid(
        columns = GridCells.Fixed(config.columns),
        modifier = modifier.padding(8.dp)
    ) {
        items(config.filas * config.columns) { index ->
            val fila = index / config.columns
            val columna = index % config.columns
            val celdaDatos = tablero[fila][columna]

            Celda(
                celda = celdaDatos,
                onClick = { fila, columna ->
                    state.desvelarCelda(fila, columna)
                },
                onLongClick = { fila, columna ->
                    state.marcarCelda(fila, columna)
                }
            )
        }
    }
}