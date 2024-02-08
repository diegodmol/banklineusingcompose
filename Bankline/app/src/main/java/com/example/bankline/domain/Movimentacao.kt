package com.example.bankline.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Movimentacao(
    val id: Int,
    val dataHora: String,
    val descricao: String,
    val valor: Double,
    val tipo: TipoMovimentacao,
    val idCorrentista: String
) : Parcelable
