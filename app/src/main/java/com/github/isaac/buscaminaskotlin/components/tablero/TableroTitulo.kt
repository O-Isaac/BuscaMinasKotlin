package com.github.isaac.buscaminaskotlin.components.tablero

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.isaac.buscaminaskotlin.R
import com.github.isaac.buscaminaskotlin.models.GameState
import com.github.isaac.buscaminaskotlin.ui.theme.PokemonAzul

@Composable
fun TableroTitulo(state: GameState = viewModel()) {
    // Caja blanca que viene desde arriba con bordes redondeados abajo
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)),
        color = Color.White.copy(alpha = 0.95f),
        shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = 16.dp, top = 24.dp) // Padding superior para el hint
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Hint para poner bandera (Dentro del bloque blanco)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Text(
                    text = "Mantén presionado para poner una bandera",
                    color = Color.Gray,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.width(6.dp))
                Image(
                    painter = painterResource(R.drawable.bandera_removebg),
                    contentDescription = null,
                    modifier = Modifier.size(14.dp)
                )
            }

            // Info de partida
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                InfoCard(
                    label = "MINAS", 
                    value = state.config.minas.toString(),
                    textColor = PokemonAzul
                )
                
                // Separador visual pequeño
                Box(
                    modifier = Modifier
                        .height(30.dp)
                        .width(1.dp)
                        .background(Color.LightGray.copy(alpha = 0.5f))
                )

                InfoCard(
                    label = "DIFICULTAD", 
                    value = state.config.nombre.uppercase(),
                    textColor = PokemonAzul
                )
            }
        }
    }
}

@Composable
fun InfoCard(label: String, value: String, textColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = label,
            color = Color.Gray.copy(alpha = 0.7f),
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp
        )
        Text(
            text = value,
            color = textColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}
