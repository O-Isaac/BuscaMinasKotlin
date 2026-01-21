package com.github.isaac.buscaminaskotlin.components.creditos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreditosScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // TÍTULO PRINCIPAL
        Text(
            text = "CRÉDITOS",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 30.dp)
        )

        // SECCIÓN 1: AUTORES
        Text(
            text = "DESARROLLADO POR:",
            color = Color.Yellow,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Text(text = "Isaac Zaragoza Mendoza", color = Color.White, fontSize = 20.sp)
        Text(text = "Rubén Segura Pérez", color = Color.White, fontSize = 20.sp)
        Text(text = "Roberto Martín Martín", color = Color.White, fontSize = 20.sp)
        Text(text = "Miguel Díaz Velasco", color = Color.White, fontSize = 20.sp)

        Spacer(modifier = Modifier.height(30.dp))


        // SECCIÓN 2: TECNOLOGÍAS
        Text(
            text = "TECNOLOGÍAS:",
            color = Color.Yellow,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Text(text = "Kotlin", color = Color.LightGray, fontSize = 20.sp)
        Text(text = "Jetpack Compose", color = Color.LightGray, fontSize = 20.sp)
        Text(text = "Android Studio", color = Color.LightGray, fontSize = 20.sp)

        Spacer(modifier = Modifier.height(50.dp))

        // BOTÓN PARA VOLVER
        Button(
            onClick = { onBackClick() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "VOLVER AL MENÚ", fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true, locale = "es")
@Composable
fun CreditosScreenPreview() {

    CreditosScreen(onBackClick = {})
}