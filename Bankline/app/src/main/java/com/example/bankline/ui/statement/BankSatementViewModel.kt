package com.example.bankline.ui.statement

import androidx.lifecycle.ViewModel
import com.example.bankline.data.BankLineRepository

class BankSatementViewModel : ViewModel() {

    fun getBankStatement(accountHolderId: Int) =
        BankLineRepository.findBankStatement(accountHolderId)
}