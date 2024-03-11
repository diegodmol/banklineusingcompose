package com.example.bankline.data.remote

import com.example.bankline.domain.Movimentacao
import retrofit2.http.GET
import retrofit2.http.Path

interface BankLineApi {
    @GET("movimentacoes/{idConta}")
    suspend fun bankStatement(@Path("idConta") accountHolderId: Int): List<Movimentacao>

}