package com.github.isaac.buscaminaskotlin.components.tablero

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.isaac.buscaminaskotlin.models.GameState
import com.github.isaac.buscaminaskotlin.ui.theme.PokemonAmarillo
import com.github.isaac.buscaminaskotlin.ui.theme.PokemonAzul

@Composable
fun TableroTitulo(state: GameState = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título Estilo Pokémon
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(PokemonAzul, PokemonAzul.copy(alpha = 0.8f))
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
                .border(3.dp, PokemonAmarillo, RoundedCornerShape(12.dp))
                .padding(horizontal = 24.dp, vertical = 8.dp)
        ) {
            Text(
                text = "BuscaMinas POKÉMON",
                color = PokemonAmarillo,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 2.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Info de partida
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            InfoCard(label = "MINAS", value = state.config.minas.toString())
            InfoCard(label = "MODO", value = state.config.nombre.uppercase())
        }
    }
}

@Composable
fun InfoCard(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = label,
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            color = PokemonAmarillo,
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}
