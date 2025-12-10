package com.github.isaac.buscaminaskotlin.models

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel
import com.github.isaac.buscaminaskotlin.confg.ConfigManagerFacil
import com.github.isaac.buscaminaskotlin.confg.GameConfig
import com.github.isaac.buscaminaskotlin.confg.IConfigManager


class GameState : ViewModel() {
    private var _configManager by mutableStateOf<IConfigManager>(ConfigManagerFacil)

    val config get() = _configManager.config

    fun changeConfigManager(configManager: IConfigManager) {
        _configManager = configManager
    }
}