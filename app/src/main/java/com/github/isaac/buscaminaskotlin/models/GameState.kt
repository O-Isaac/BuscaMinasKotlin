package com.github.isaac.buscaminaskotlin.models

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.github.isaac.buscaminaskotlin.confg.ConfigManagerMedia
import com.github.isaac.buscaminaskotlin.confg.IConfigManager
import kotlin.random.Random

class GameState : ViewModel() {

    // Simplificamos la clase de datos para que sea más clara
    class CeldaData(
        tipoInicial: TipoCelda = TipoCelda.LIBRE
    ) {
        var tipo by mutableStateOf(tipoInicial)
        var visible by mutableStateOf(false)
        var contador by mutableStateOf(0)
        var marcada by mutableStateOf(false) // Para poner banderitas
    }

    enum class TipoCelda { MINA, LIBRE }
    enum class EstadoPartida { JUGANDO, GANADO, PERDIDO }

    private var _configManager by mutableStateOf<IConfigManager>(ConfigManagerMedia)
    val config get() = _configManager.config

    // El tablero es una lista de listas para facilitar la reactividad en Compose
    var tablero by mutableStateOf(crearTablero())
        private set

    var estadoPartida by mutableStateOf(EstadoPartida.JUGANDO)
        private set

    private fun crearTablero(): List<List<CeldaData>> {
        return List(config.filas) {
            List(config.columns) { CeldaData() }
        }
    }

    fun reiniciarJuego() {
        tablero = crearTablero()
        estadoPartida = EstadoPartida.JUGANDO
        plantarMinas()
        calcularNumerosTablero()
    }

    private fun plantarMinas() {
        var minasColocadas = 0
        val totalCeldas = config.filas * config.columns
        val maxMinas = minOf(config.minas, totalCeldas - 1)

        while (minasColocadas < maxMinas) {
            val fila = Random.nextInt(config.filas)
            val columna = Random.nextInt(config.columns)

            if (tablero[fila][columna].tipo == TipoCelda.LIBRE) {
                tablero[fila][columna].tipo = TipoCelda.MINA // Corregido: antes tenías ==
                minasColocadas++
            }
        }
    }

    private fun calcularNumerosTablero() {
        for (f in 0 until config.filas) {
            for (c in 0 until config.columns) {
                if (tablero[f][c].tipo == TipoCelda.MINA) {
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
                        tablero[f][c].contador++
                    }
                }
            }
        }
    }

    // --- Lógica de Juego ---

    fun desvelarCelda(f: Int, c: Int) {
        val celda = tablero[f][c]

        // Si ya es visible, está marcada o terminó el juego, no hacer nada
        if (celda.visible || celda.marcada || estadoPartida != EstadoPartida.JUGANDO) return

        celda.visible = true

        if (celda.tipo == TipoCelda.MINA) {
            finalizarPartida(EstadoPartida.PERDIDO)
            return
        }

        // Si la celda está vacía (contador 0), desvelar vecinos automáticamente (recursión)
        if (celda.contador == 0) {
            desvelarVecinosVacios(f, c)
        }

        verificarVictoria()
    }

    private fun desvelarVecinosVacios(fila: Int, col: Int) {
        for (f in (fila - 1)..(fila + 1)) {
            for (c in (col - 1)..(col + 1)) {
                if (f in 0 until config.filas && c in 0 until config.columns) {
                    if (!tablero[f][c].visible) {
                        desvelarCelda(f, c)
                    }
                }
            }
        }
    }

    private fun verificarVictoria() {
        // Victoria: Todas las celdas LIBRE son visibles
        val todasLibresDesveladas = tablero.flatten().all {
            it.tipo == TipoCelda.MINA || it.visible
        }

        if (todasLibresDesveladas) {
            finalizarPartida(EstadoPartida.GANADO)
        }
    }

    private fun finalizarPartida(resultado: EstadoPartida) {
        estadoPartida = resultado
        if (resultado == EstadoPartida.PERDIDO) {
            // Opcional: Mostrar todas las minas al perder
            tablero.flatten().filter { it.tipo == TipoCelda.MINA }.forEach { it.visible = true }
        }

        // TODO: Lógica adicional de Game Over o Victoria (sonidos, persistencia, etc.)
        println("Fin de la partida: $resultado")
    }

    fun changeConfigManager(configManager: IConfigManager) {
        _configManager = configManager
        reiniciarJuego() // Reiniciamos al cambiar dificultad
    }
}