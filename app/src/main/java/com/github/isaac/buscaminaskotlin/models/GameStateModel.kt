package com.github.isaac.buscaminaskotlin.models

import androidx.lifecycle.ViewModel
import com.github.isaac.buscaminaskotlin.confg.ConfigManagerFacil
import com.github.isaac.buscaminaskotlin.confg.IGameConfig

class GameStateModel : ViewModel() {
    private var _gameConfig: IGameConfig = ConfigManagerFacil

    fun getCurrentGameConfig(): IGameConfig {
        return _gameConfig
    }

    fun changeGameConfig(gameConfig: IGameConfig) {
        _gameConfig = gameConfig
    }
}