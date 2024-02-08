package com.example.bankline.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuItem(
    val icone: Int,
    val descricao: String,
    val posicao: Int,
) : Parcelable