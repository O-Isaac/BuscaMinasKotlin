package com.github.isaac.buscaminaskotlin.components.tablero

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.isaac.buscaminaskotlin.models.GameState
import com.github.isaac.buscaminaskotlin.ui.theme.PokemonAzul

@Composable
fun TableroTitulo(state: GameState = viewModel()) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = when (state.estadoPartida) {
                GameState.EstadoPartida.JUGANDO -> "¡Hazte con todos!"
                GameState.EstadoPartida.GANADO -> "¡ERES EL CAMPEÓN! 🏆"
                GameState.EstadoPartida.PERDIDO -> "¡Voltorb usó Autodestrucción! 💥"
            },
            style = MaterialTheme.typography.headlineMedium,
            color = PokemonAzul
        )

        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Minas: ${state.config.minas}")
            VerticalDivider(modifier = Modifier.height(15.dp), thickness = 2.dp)
            Text("Modo: ${state.config.nombre}")
        }

        if (state.estadoPartida != GameState.EstadoPartida.JUGANDO) {
            Button(onClick = { state.reiniciarJuego() }, modifier = Modifier.padding(8.dp)) {
                Text("Reintentar")
            }
        }
    }
}