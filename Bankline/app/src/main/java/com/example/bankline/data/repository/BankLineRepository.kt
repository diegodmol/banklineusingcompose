package com.example.bankline.data.repository

import com.example.bankline.domain.Movimentacao

interface BankLineRepository {
    suspend fun findBankStatement(accountHolderId: Int) : List<Movimentacao>
}