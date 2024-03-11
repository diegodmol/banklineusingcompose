package com.example.bankline.ui.statement

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankline.data.State
import com.example.bankline.data.repository.BankLineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG_ERROR = "Error"

@HiltViewModel
class BankSatementViewModel @Inject constructor(private val repository: BankLineRepository) :
    ViewModel() {

    private val _data = MutableLiveData<State<*>>()
    val data: LiveData<State<*>> = _data

    fun loadBankStatement(accountHolderId: Int) {
        viewModelScope.launch {
            _data.value = State.Loading
            runCatching { repository.findBankStatement(accountHolderId) }
                .fold(onSuccess = {
                    _data.value =
                        State.Success(data = repository.findBankStatement(accountHolderId))
                },
                    onFailure = { error ->
                        _data.value = State.Error(error.message)
                    })
        }
    }
}

