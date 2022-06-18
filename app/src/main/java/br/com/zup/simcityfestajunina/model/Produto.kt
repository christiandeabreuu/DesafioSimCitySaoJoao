package br.com.zup.simcityfestajunina.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Produto(
    private val nome: String,
    private val qtd: Int,
    private val valor: Double,
    private val receita: String
) : Parcelable {
    fun getNome() = nome
    fun getQtd() = qtd
    fun getValor() = valor
    fun getReceita() = receita

}