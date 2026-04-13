package com.example.controlefinanceirocompose

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf


data class Sonho(
    val nome: String,
    val valor: androidx.compose.runtime.MutableState<Double>
)
object Banco {

    var saldo = mutableStateOf(0.0)

    val extrato = mutableStateListOf<String>()

    val sonhos = mutableStateListOf<Sonho>()

    fun adicionar(valor: Double) {
        saldo.value += valor
        extrato.add("+ R$ $valor")
    }

    fun remover(valor: Double) {
        saldo.value -= valor
        extrato.add("- R$ $valor")
    }

    fun criarSonho(nome: String) {
        sonhos.add(
            Sonho(
                nome,
                mutableStateOf(0.0)
            )
        )
    }

    fun adicionarAoSonho(sonho: Sonho, valor: Double) {
        if (saldo.value >= valor) {

            saldo.value -= valor
            sonho.valor.value += valor

            extrato.add("Sonho ${sonho.nome} + R$ $valor")
        }
    }
}