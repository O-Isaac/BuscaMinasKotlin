package com.github.isaac.buscaminaskotlin.navigation.root

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.BackStackModel
import com.bumble.appyx.components.backstack.ui.parallax.BackStackParallax
import com.bumble.appyx.navigation.composable.AppyxNavigationContainer
import com.bumble.appyx.navigation.modality.NodeContext
import com.bumble.appyx.navigation.node.Node
import com.bumble.appyx.navigation.node.node
import com.github.isaac.buscaminaskotlin.components.ajustes.AjustesScreen
import com.github.isaac.buscaminaskotlin.components.menu.MenuScreen
import com.github.isaac.buscaminaskotlin.components.tablero.Layout
import kotlinx.parcelize.Parcelize

fun createBackStack(nodeContext: NodeContext): BackStack<RootNode.NavTarget> {
    return BackStack(
        model = BackStackModel(
            initialTargets = listOf(RootNode.NavTarget.MenuScreen),
            savedStateMap = nodeContext.savedStateMap
        ),
        visualisation = { BackStackParallax(it) }
    )
}

class RootNode(
    nodeContext: NodeContext,
    private val backStack: BackStack<NavTarget> = createBackStack(nodeContext)
) : Node<RootNode.NavTarget>(
    appyxComponent = backStack,
    nodeContext = nodeContext
) {

    sealed class NavTarget : Parcelable {
        @Parcelize
        data object MenuScreen : NavTarget()

        @Parcelize
        data object AjusteScreen : NavTarget()

        @Parcelize
        data object TableroScreen : NavTarget()
    }

    override fun buildChildNode(navTarget: NavTarget, nodeContext: NodeContext): Node<*> =
        when (navTarget) {
            is NavTarget.MenuScreen -> node(nodeContext) {
                MenuScreen(backStack)
            }

            is NavTarget.AjusteScreen -> node(nodeContext) {
                AjustesScreen()
            }

            is NavTarget.TableroScreen -> node(nodeContext) {
                Layout()
            }
        }

    @Composable
    override fun Content(modifier: Modifier) {
        AppyxNavigationContainer(
            appyxComponent = backStack,
            modifier = modifier
        )
    }
}
