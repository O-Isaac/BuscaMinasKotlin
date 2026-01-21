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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.operation.push
import com.github.isaac.buscaminaskotlin.navigation.root.RootNode


@Composable
fun MenuScreen(backStack: BackStack<RootNode.NavTarget>) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Image(
            painter = painterResource(R.drawable.fondo2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.buscaminasmenu),
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp)
                    .padding(bottom = 212.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
            MenuButton(
                texto = "Nueva partida",
                onClick = { backStack.push(RootNode.NavTarget.TableroScreen) })
            // Acción al hacer clic en "Nueva partida"
            Spacer(modifier = Modifier.height(16.dp))
            MenuButton(
                texto = "Configuración",
                onClick = { backStack.push(RootNode.NavTarget.AjusteScreen)}
            )
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
    // MenuScreen()
}