package com.github.isaac.buscaminaskotlin.components.menu

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MenuButton(texto: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)) {
        Text(text = texto,
            modifier = Modifier.align(Alignment.CenterVertically),
            textAlign = TextAlign.Center)
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