package com.github.isaac.buscaminaskotlin.confg

data class GameConfig(
    var filas: Int,
    var columns: Int,
)

object ConfigManagerFacil {
    val config = GameConfig(10,10)
}

object ConfigManagerIntermedio {
    val config = GameConfig(15,15)
}
