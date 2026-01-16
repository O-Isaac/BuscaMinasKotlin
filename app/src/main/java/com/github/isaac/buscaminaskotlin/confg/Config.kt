package com.github.isaac.buscaminaskotlin.confg

// Necesario para manejar el estado de las dificultades
interface IConfigManager {
    var config: GameConfig
}

data class GameConfig(
    var filas: Int,
    var columns: Int,
    var minas: Int,
)

object ConfigManagerBaja : IConfigManager {
    override var config = GameConfig(10, 10, 10)
}

object ConfigManagerMedia : IConfigManager {
    override var config = GameConfig(15, 15, 20)
}

object ConfigManagerAlta : IConfigManager {
    override var config = GameConfig(20, 20, 30)
}

// Keep old names for backward compatibility
object ConfigManagerFacil : IConfigManager {
    override var config = GameConfig(10, 10, 10)
}

object ConfigManagerIntermedio : IConfigManager {
    override var config = GameConfig(15, 15, 20)
}
