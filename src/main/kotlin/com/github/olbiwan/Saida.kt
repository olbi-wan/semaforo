package com.github.olbiwan

/**
 * Acao/Saida do semaforo.
 */
interface Saida {
    fun executar(cor: Cor, tempo: Number)
}