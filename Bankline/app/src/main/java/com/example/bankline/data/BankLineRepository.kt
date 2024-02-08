package com.example.bankline.data

import android.util.Log
import androidx.lifecycle.liveData
import com.example.bankline.data.remote.BankLineApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BankLineRepository {

    private val TAG_ERROR = javaClass.simpleName

    private val api by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BankLineApi::class.java)
    }

    fun findBankStatement(accountHolderId: Int) = liveData {
        emit(State.Loading)
        try {
            emit(State.Success(data = api.bankStatement(accountHolderId)))
        } catch (e: Exception) {
            Log.e(TAG_ERROR, e.message, e)
            emit(State.Error(e.message))
        }

    }
}