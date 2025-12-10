package com.github.isaac.buscaminaskotlin.confg

// Necesario para manejar el estado de las dificultades
interface IGameConfig {
    val config: GameConfig
}

data class GameConfig(
    var filas: Int,
    var columns: Int,
)

object ConfigManagerFacil : IGameConfig {
    override val config = GameConfig(10,10)
}

object ConfigManagerIntermedio : IGameConfig {
    override val config = GameConfig(15,15)
}
