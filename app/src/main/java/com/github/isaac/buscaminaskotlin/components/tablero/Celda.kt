package com.github.isaac.buscaminaskotlin.components.tablero

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.isaac.buscaminaskotlin.ui.theme.PokemonAmarillo
import com.github.isaac.buscaminaskotlin.ui.theme.PokemonAzul

@Composable
fun Celda(modifier: Modifier = Modifier,
          fila: Int,
          columna: Int,
          onClick: (Int, Int) -> Unit) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(PokemonAmarillo)
            .border(2.dp, PokemonAzul)
            .clickable { onClick(fila, columna) },
        contentAlignment = Alignment.Center
    ) {
        Text("$fila,$columna")
    }

    Spacer(modifier = Modifier.height(16.dp))

}