package com.github.isaac.buscaminaskotlin.components.tablero

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.isaac.buscaminaskotlin.confg.ConfigManagerFacil

@Composable
fun TableroGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(ConfigManagerFacil.config.columns),
        modifier = Modifier.fillMaxSize()
    ) {
        items(ConfigManagerFacil.config.filas * ConfigManagerFacil.config.columns) { index ->
            val fila = index / ConfigManagerFacil.config.columns
            val columna = index % ConfigManagerFacil.config.columns

            Celda(fila = fila, columna = columna) { f, c ->
                Log.d("BuscaMinas", "Click en $f, $c")
            }
        }
    }
}