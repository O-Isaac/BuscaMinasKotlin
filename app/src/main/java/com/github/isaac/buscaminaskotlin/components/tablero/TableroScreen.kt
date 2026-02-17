package com.github.isaac.buscaminaskotlin.components.tablero

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.isaac.buscaminaskotlin.R
import com.github.isaac.buscaminaskotlin.models.GameState

@Composable
fun Layout(state: GameState = viewModel()) {
    // Inicializar el tablero si es la primera vez
    LaunchedEffect(Unit) {
        state.reiniciarJuego()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Fondo del menú principal
        Image(
            painter = painterResource(R.drawable.fondo2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TableroTitulo(state)
            TableroGrid(state = state)
        }

        // Overlay de Fin de Partida (Encima de todo)
        AnimatedVisibility(
            visible = state.estadoPartida != GameState.EstadoPartida.JUGANDO,
            enter = fadeIn(animationSpec = tween(800)),
            exit = fadeOut()
        ) {
            GameOverOverlay(state)
        }
    }
}

@Composable
fun GameOverOverlay(state: GameState) {
    val isWin = state.estadoPartida == GameState.EstadoPartida.GANADO
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.7f)), // Fondo negro atenuado
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {
            // Texto estilo Dark Souls
            Text(
                text = if (isWin) "¡CAMPEÓN LIGA!" else "VOLTORB SE\nAUTODESTRUYÓ",
                color = if (isWin) Color(0xFFFFCC00) else Color(0xFFD32F2F),
                fontSize = 40.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center,
                lineHeight = 48.sp,
                letterSpacing = 4.sp
            )
            
            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { state.reiniciarJuego() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                border = androidx.compose.foundation.BorderStroke(2.dp, Color.White),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "REINTENTAR",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )
            }
        }
    }
}
