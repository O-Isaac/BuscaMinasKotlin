package com.github.isaac.buscaminaskotlin.models

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.isaac.buscaminaskotlin.confg.ConfigManagerMedia
import com.github.isaac.buscaminaskotlin.confg.IConfigManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

enum class TipoCelda { MINA, LIBRE }

class CeldaInfo(
    val row: Int,
    val col: Int,
    tipoInicial: TipoCelda = TipoCelda.LIBRE
) {
    var tipo by mutableStateOf(tipoInicial)
    var estaRevelada by mutableStateOf(false)
    var minasCerca by mutableStateOf(0)
    var estaMarcada by mutableStateOf(false)

    val esMina get() = tipo == TipoCelda.MINA
}

class GameState : ViewModel() {

    enum class EstadoPartida { JUGANDO, GANADO, PERDIDO }

    private var _configManager by mutableStateOf<IConfigManager>(ConfigManagerMedia)
    val config get() = _configManager.config

    var tablero by mutableStateOf(crearTablero())
        private set

    var estadoPartida by mutableStateOf(EstadoPartida.JUGANDO)
        private set

    private var esPrimerToque = true

    private fun crearTablero(): List<List<CeldaInfo>> {
        return List(config.filas) { r ->
            List(config.columns) { c -> CeldaInfo(r, c) }
        }
    }

    fun reiniciarJuego() {
        tablero = crearTablero()
        estadoPartida = EstadoPartida.JUGANDO
        esPrimerToque = true
    }

    private fun plantarMinas(filaExcluida: Int, colExcluida: Int) {
        var minasColocadas = 0
        val totalCeldas = config.filas * config.columns
        val maxMinas = minOf(config.minas, totalCeldas - 1)

        while (minasColocadas < maxMinas) {
            val fila = Random.nextInt(config.filas)
            val columna = Random.nextInt(config.columns)

            // Evitar que el primer click sea una mina
            if (fila == filaExcluida && columna == colExcluida) continue

            if (tablero[fila][columna].tipo == TipoCelda.LIBRE) {
                tablero[fila][columna].tipo = TipoCelda.MINA
                minasColocadas++
            }
        }
    }

    private fun calcularNumerosTablero() {
        for (f in 0 until config.filas) {
            for (c in 0 until config.columns) {
                if (tablero[f][c].esMina) {
                    incrementarVecinosDeMina(f, c)
                }
            }
        }
    }

    private fun incrementarVecinosDeMina(filaMina: Int, colMina: Int) {
        for (f in (filaMina - 1)..(filaMina + 1)) {
            for (c in (colMina - 1)..(colMina + 1)) {
                if (f in 0 until config.filas && c in 0 until config.columns) {
                    if (tablero[f][c].tipo == TipoCelda.LIBRE) {
                        tablero[f][c].minasCerca++
                    }
                }
            }
        }
    }

    fun desvelarCelda(f: Int, c: Int) {
        if (estadoPartida != EstadoPartida.JUGANDO) return

        val celda = tablero[f][c]

        if (celda.estaRevelada || celda.estaMarcada) return

        if (esPrimerToque) {
            esPrimerToque = false
            // Lanzamos corrutina para generar el tablero en segundo plano
            viewModelScope.launch {
                withContext(Dispatchers.Default) {
                    plantarMinas(f, c)
                    calcularNumerosTablero()
                }
                realizarLogicaDesvelar(f, c)
            }
        } else {
            realizarLogicaDesvelar(f, c)
        }
    }

    private fun realizarLogicaDesvelar(f: Int, c: Int) {
        val celda = tablero[f][c]
        if (celda.estaRevelada || celda.estaMarcada) return

        celda.estaRevelada = true

        if (celda.esMina) {
            finalizarPartida(EstadoPartida.PERDIDO)
            return
        }

        if (celda.minasCerca == 0) {
            desvelarVecinosVacios(f, c)
        }

        verificarVictoria()
    }

    fun marcarCelda(f: Int, c: Int) {
        if (estadoPartida != EstadoPartida.JUGANDO) return
        val celda = tablero[f][c]
        if (!celda.estaRevelada) {
            celda.estaMarcada = !celda.estaMarcada
        }
    }

    private fun desvelarVecinosVacios(fila: Int, col: Int) {
        for (f in (fila - 1)..(fila + 1)) {
            for (c in (col - 1)..(col + 1)) {
                if (f in 0 until config.filas && c in 0 until config.columns) {
                    if (!tablero[f][c].estaRevelada) {
                        realizarLogicaDesvelar(f, c)
                    }
                }
            }
        }
    }

    private fun verificarVictoria() {
        val todasLibresDesveladas = tablero.flatten().all {
            it.esMina || it.estaRevelada
        }

        if (todasLibresDesveladas) {
            finalizarPartida(EstadoPartida.GANADO)
        }
    }

    private fun finalizarPartida(resultado: EstadoPartida) {
        estadoPartida = resultado
        if (resultado == EstadoPartida.PERDIDO) {
            tablero.flatten().filter { it.esMina }.forEach { it.estaRevelada = true }
        }
    }

    fun changeConfigManager(configManager: IConfigManager) {
        _configManager = configManager
        reiniciarJuego()
    }
}
