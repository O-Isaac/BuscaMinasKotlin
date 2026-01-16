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

// Deprecated: Use ConfigManagerBaja instead
@Deprecated("Use ConfigManagerBaja instead", ReplaceWith("ConfigManagerBaja"))
val ConfigManagerFacil = ConfigManagerBaja

// Deprecated: Use ConfigManagerMedia instead
@Deprecated("Use ConfigManagerMedia instead", ReplaceWith("ConfigManagerMedia"))
val ConfigManagerIntermedio = ConfigManagerMedia
