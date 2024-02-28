package com.example.bankline.ui.statement

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.bankline.data.State
import com.example.bankline.data.repository.BankLineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

const val TAG_ERROR = "Error"

@HiltViewModel
class BankSatementViewModel @Inject constructor(private val repository: BankLineRepository) :
    ViewModel() {

    fun findBankStatement(accountHolderId: Int) = liveData {
        emit(State.Loading)
        try {
            emit(State.Success(data = repository.findBankStatement(accountHolderId)))
        } catch (e: Exception) {
            Log.e(TAG_ERROR, e.message, e)
            emit(State.Error(e.message))
        }

    }
}