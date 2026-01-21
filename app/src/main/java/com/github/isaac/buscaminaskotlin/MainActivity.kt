package com.github.isaac.buscaminaskotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat.enableEdgeToEdge
import com.bumble.appyx.core.integration.NodeHost
import com.github.isaac.buscaminaskotlin.navigation.NavigationActivity
import com.github.isaac.buscaminaskotlin.navigation.RootNode
import com.github.isaac.buscaminaskotlin.ui.theme.BuscaMinasKotlinTheme

class MainActivity : NavigationActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuscaMinasKotlinTheme {
                NodeHost(integrationPoint = appyxV1IntegrationPoint) {
                    RootNode(buildContext = it)
                }
            }
        }
    }
}

