package com.github.isaac.buscaminaskotlin

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.bumble.appyx.navigation.integration.NodeActivity
import com.bumble.appyx.navigation.integration.NodeHost
import com.bumble.appyx.navigation.platform.AndroidLifecycle
import com.github.isaac.buscaminaskotlin.navigation.RootNode
import com.github.isaac.buscaminaskotlin.ui.theme.BuscaMinasKotlinTheme

class MainActivity : NodeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuscaMinasKotlinTheme {
                NodeHost(
                    lifecycle = AndroidLifecycle(LocalLifecycleOwner.current.lifecycle),
                    integrationPoint = appyxIntegrationPoint
                ) {
                    RootNode(nodeContext = it)
                }
            }
        }
    }
}

