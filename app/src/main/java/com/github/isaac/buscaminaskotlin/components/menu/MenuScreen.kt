package com.github.isaac.buscaminaskotlin.components.menu

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import com.github.isaac.buscaminaskotlin.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MenuScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Column(
            Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.buscaminasmenu),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "MENÚ PRINCIPAL",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            MenuButton(
                texto = "Nueva partida",
                onClick = { Log.d("MenuScreen", "Nueva partida clicked") })
            // Acción al hacer clic en "Nueva partida"
            Spacer(modifier = Modifier.height(16.dp))
            MenuButton(
                texto = "Configuración",
                onClick = { Log.d("MenuScreen ", "Configuración clicked") })
            // Acción al hacer clic en "Configuración"
            Spacer(modifier = Modifier.height(16.dp))
            MenuButton(
                texto = "Salir",
                onClick = { Log.d("MenuScreen", "Salir clicked") })
            // Acción al hacer clic en "Salir"
        }

    }

}


@Preview(showBackground = true, locale = "es")
@Composable
fun MenuScreenPreview() {
    //val navController = rememberNavController()

    MenuScreen()
}