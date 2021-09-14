package com.github.olbiwan

import java.util.concurrent.TimeUnit.SECONDS

/**
 * Representa o semaforo e suas fases (cores).
 */
data class Semaforo(private var fase: Fase, private val botao: Boolean, private val saida: Saida) {

    // "Percetual" de "paralizacao" caso o [botao] de travessia esteja pressionado.
    companion object { private const val PERCENTUAL_PARADA: Float = 0.2F }

    // Inicia as fases (cores) do semaforo.
    fun iniciar() {
        for (i in 1..5) {
            executar(fase.cor, calcularTempo())
            fase = fase.proxima
        }
    }

    // Calcula o tempo que uma fase (cor) fica ativa.
    private fun calcularTempo() : Number = if(botao) fase.pausa(fase.tempo, PERCENTUAL_PARADA) else fase.tempo

    private fun executar(cor: Cor, tempo: Number) {
        saida.executar(cor, tempo)
        SECONDS.sleep(tempo.toLong())
    }

}