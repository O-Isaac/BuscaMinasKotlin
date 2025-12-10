package com.github.isaac.buscaminaskotlin.confg

// Necesario para manejar el estado de las dificultades
interface IConfigManager {
    var config: GameConfig
}

data class GameConfig(
    var filas: Int,
    var columns: Int,
)

object ConfigManagerFacil : IConfigManager {
    override var config = GameConfig(10,10)
}

object ConfigManagerIntermedio : IConfigManager {
    override var config = GameConfig(15,15)
}
