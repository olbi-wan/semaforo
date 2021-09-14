package com.github.olbiwan

/**
 * Reprenta as fases (cores) do semaforo.
 * @param cor cor da fase
 * @param tempo tempo que a fase (cor) permanecera ativa
 * @param pausa regra executada quando o botao de parada estiver pressionado
 * @see Cor
 */
data class Fase(val cor: Cor, val tempo: Int, val pausa: (Int, Float) -> Float) {
    // Proxima fase (cor).
    lateinit var proxima: Fase
}