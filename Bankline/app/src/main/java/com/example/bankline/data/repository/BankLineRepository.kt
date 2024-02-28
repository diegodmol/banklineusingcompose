package com.example.bankline.data.repository

import com.example.bankline.domain.Movimentacao

interface BankLineRepository {
    fun findBankStatement(accountHolderId: Int) : List<Movimentacao>
}