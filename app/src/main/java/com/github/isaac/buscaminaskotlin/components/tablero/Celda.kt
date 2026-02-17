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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.github.isaac.buscaminaskotlin.models.GameState
import com.github.isaac.buscaminaskotlin.ui.theme.PokemonAmarillo
import com.github.isaac.buscaminaskotlin.ui.theme.PokemonAzul

@Composable
fun Celda(
    modifier: Modifier = Modifier,
    datos: GameState.CeldaData,
    onClick: () -> Unit
) {
    val colorFondo = if (datos.visible) Color.White else PokemonAmarillo
    val colorBorde = PokemonAzul

    Box(
        modifier = modifier
            .size(40.dp)
            .background(colorFondo)
            .border(1.dp, colorBorde)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (datos.visible) {
            when (datos.tipo) {
                GameState.TipoCelda.MINA -> Text("💣") // Aquí podrías poner un icono de Voltorb
                GameState.TipoCelda.LIBRE -> {
                    if (datos.contador > 0) {
                        Text(
                            text = datos.contador.toString(),
                            color = obtenerColorNumero(datos.contador),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        } else {
            // Celda oculta: podrías poner un icono de hierba alta
            if (datos.marcada) Text("🚩")
        }
    }
}

private fun obtenerColorNumero(contador: Int): Color {
    return when (contador) {
        1 -> Color(0xFF1976D2) // Azul
        2 -> Color(0xFF388E3C) // Verde
        3 -> Color(0xFFD32F2F) // Rojo
        else -> Color.Magenta
    }
}