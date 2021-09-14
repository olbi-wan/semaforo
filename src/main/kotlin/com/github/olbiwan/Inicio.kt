package com.github.olbiwan

private val saida: Saida = object : Saida {
    override fun executar(cor: Cor, tempo: Number) = println("cor:$cor & tempo:$tempo")
}

fun main() {

    val vermelha = Fase(Cor.VERMELHA, 1) { tempo, percentual -> tempo * (percentual + 1) }
    val amarela  = Fase(Cor.AMARELA,  2) { tempo, _ -> tempo.toFloat() }
    val verde    = Fase(Cor.VERDE,    3) { tempo, percentual -> tempo - (tempo * percentual) }

    piscante(amarela, false)                   // Semaforo com amarelo piscante.
    println()
    tresCores(vermelha, amarela, verde, false) // Semaforo normal.
    println()
    tresCores(vermelha, amarela, verde, true)  // Semaforo normal com o botao de travessia pressionado.

}

fun piscante(amarela: Fase, botao: Boolean) = Semaforo(amarela.also { it.proxima = amarela }, botao, saida).iniciar()

fun tresCores(vermelha: Fase, amarela: Fase, verde: Fase, botao: Boolean) {
    vermelha.proxima = verde
    amarela.proxima  = vermelha
    verde.proxima    = amarela
    Semaforo(vermelha, botao, saida).iniciar()
}