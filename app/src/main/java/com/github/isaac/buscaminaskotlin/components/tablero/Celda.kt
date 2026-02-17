package com.github.isaac.buscaminaskotlin.components.tablero

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.isaac.buscaminaskotlin.R
import com.github.isaac.buscaminaskotlin.models.CeldaInfo
import com.github.isaac.buscaminaskotlin.ui.theme.PokemonAmarillo
import com.github.isaac.buscaminaskotlin.ui.theme.PokemonAzul

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Celda(
    celda: CeldaInfo,
    onClick: (Int, Int) -> Unit,
    onLongClick: (Int, Int) -> Unit
) {
    val backgroundColor = when {
        celda.estaRevelada && celda.esMina -> Color.Red
        celda.estaRevelada -> Color.White.copy(alpha = 0.7f)
        else -> PokemonAmarillo.copy(alpha = 0.9f)
    }

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .background(backgroundColor)
            .border(0.5.dp, PokemonAzul.copy(alpha = 0.5f))
            .combinedClickable(
                onClick = { onClick(celda.row, celda.col) },
                onLongClick = { onLongClick(celda.row, celda.col) }
            ),
        contentAlignment = Alignment.Center
    ) {
        if (celda.estaRevelada) {
            when {
                celda.esMina -> Text("💣", fontSize = 16.sp)
                celda.minasCerca > 0 -> Text(
                    text = celda.minasCerca.toString(),
                    color = getNumeroColor(celda.minasCerca),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        } else if (celda.estaMarcada) {
            // Usamos el drawable de la bandera personalizada
            Image(
                painter = painterResource(R.drawable.bandera_removebg),
                contentDescription = "Bandera",
                modifier = Modifier
                    .size(24.dp)
                    .padding(2.dp)
            )
        }
    }
}

private fun getNumeroColor(numero: Int): Color {
    return when (numero) {
        1 -> Color(0xFF1976D2) // Azul
        2 -> Color(0xFF388E3C) // Verde
        3 -> Color(0xFFD32F2F) // Rojo
        4 -> Color(0xFF7B1FA2) // Púrpura
        5 -> Color(0xFFBF360C) // Naranja oscuro
        else -> Color.Gray
    }
}
