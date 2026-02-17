package com.github.isaac.buscaminaskotlin.components.tablero

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumble.appyx.components.backstack.BackStack
import com.github.isaac.buscaminaskotlin.models.GameState
import com.github.isaac.buscaminaskotlin.navigation.RootNode
import kotlinx.coroutines.delay

@Composable
fun TableroGrid(modifier: Modifier = Modifier, backStack: BackStack<RootNode.NavTarget>, state: GameState = viewModel()) {
    val config = state.config
    val tablero = state.tablero
    var visible by remember { mutableStateOf(false) }
    val isAnimating by backStack.isAnimating.collectAsState()
    var firstTime by remember { mutableStateOf(true) }

    LaunchedEffect(isAnimating) {
        if (!isAnimating) {
            // La animación ha terminado y el modelo está en reposo
            delay(100)
            visible = true
        }
    }

    if (visible) {
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
}