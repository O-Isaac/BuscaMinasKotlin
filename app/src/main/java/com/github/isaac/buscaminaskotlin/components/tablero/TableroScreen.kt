package com.github.isaac.buscaminaskotlin.components.tablero

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.isaac.buscaminaskotlin.confg.ConfigManagerIntermedio
import com.github.isaac.buscaminaskotlin.models.GameState

@Composable
fun Layout(state: GameState = viewModel()) {
    val config = state.config

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(config.columns),
            modifier = Modifier
                .weight(1f) // ocupa espacio disponible
                .fillMaxSize()
        ) {
            items(count = config.filas * config.columns, key = { index ->
                val fila = index / config.columns
                val columna = index % config.columns
                fila * config.columns + columna // clave única
            }) { index ->
                val fila = index / config.columns
                val columna = index % config.columns

                Celda(fila = fila, columna = columna) { f, c ->
                    Log.d("BuscaMinas", "Click en $f, $c")
                }
            }
        }

    }
}