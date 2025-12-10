package com.github.isaac.buscaminaskotlin.components.tablero

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.isaac.buscaminaskotlin.confg.ConfigManagerFacil
import com.github.isaac.buscaminaskotlin.models.GameState

@Composable
fun TableroGrid(modifier: Modifier = Modifier, state: GameState = viewModel()) {
    val config = state.config
    LazyVerticalGrid(
        columns = GridCells.Fixed(config.columns),
        modifier = Modifier.fillMaxSize()
    ) {
        items(config.filas * config.columns) { index ->
            val fila = index / config.columns
            val columna = index % config.columns

            Celda(fila = fila, columna = columna) { f, c ->
                Log.d("BuscaMinas", "Click en $f, $c")
            }
        }
    }
}