package com.github.isaac.buscaminaskotlin.components.menu

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.ui.graphics.Brush

@Composable
fun MenuButton(texto: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        // Sombra del botón (debajo)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .offset(y = 6.dp)
                .background(
                    color = Color(0xFF8B7000),
                    shape = RoundedCornerShape(16.dp)
                )
        )

        // Botón principal
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFD54F), // Amarillo más suave estilo DS
                contentColor = Color(0xFF2C2C2C) // Texto negro/gris oscuro
            ),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(4.dp, Color(0xFFFFF9C4)), // Borde amarillo claro (brillo superior)
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 6.dp,
                pressedElevation = 2.dp
            )
        ) {
            Text(
                text = texto,
                modifier = Modifier.align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2C2C2C)
            )
        }
    }
}

@Preview(showBackground = true, locale = "es")
@Composable
fun MenuButtonPreview() {
    //val navController = rememberNavController()

    MenuButton(
        texto = "Nueva partida",
        onClick = { Log.d("MenuScreen", "Nueva partida clicked") })
}