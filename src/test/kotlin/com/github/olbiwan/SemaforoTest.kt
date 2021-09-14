package com.github.olbiwan

import org.junit.Test
import org.mockito.Mockito.*
import kotlin.random.Random.Default.nextFloat

class SemaforoTest {

    @Test
    fun `Deve poder criar um semaforo com amarelo piscante`() {

        val cor = Cor.AMARELA; val tempo = 2

        val saida = mock(Saida::class.java)
        val amarela = Fase(cor,  tempo) { _, _ -> nextFloat() }

        Semaforo(amarela.also { it.proxima = amarela }, false, saida).iniciar()

        verify(saida, times(5)).executar(cor, tempo)

    }

}