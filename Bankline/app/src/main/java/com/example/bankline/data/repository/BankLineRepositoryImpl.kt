package com.example.bankline.data.repository

import com.example.bankline.data.remote.BankLineApi
import com.example.bankline.domain.Movimentacao
import javax.inject.Inject

class BankLineRepositoryImpl @Inject constructor(
    private val api: BankLineApi
) : BankLineRepository {
    override fun findBankStatement(accountHolderId: Int): List<Movimentacao> {
        return api.bankStatement(accountHolderId)
    }
}