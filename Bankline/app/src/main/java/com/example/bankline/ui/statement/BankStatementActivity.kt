package com.example.bankline.ui.statement

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankline.data.State
import com.example.bankline.databinding.ActivityBankStatementBinding
import com.example.bankline.domain.Correntista
import com.example.bankline.domain.Movimentacao
import com.example.bankline.ui.statement.adapter.BankStatementAdapter
import com.google.android.material.snackbar.Snackbar

class BankStatementActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityBankStatementBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<BankSatementViewModel>()

    private val accountHolderId by lazy {
        intent.getParcelableExtra<Correntista>(EXTRA_ACCOUNT_HOLDER)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setViews()
        findBankStatement()
    }

    private fun setViews() {
        with(binding) {
            rvBankStatement.layoutManager = LinearLayoutManager(this@BankStatementActivity)
            srlBankStatement.setOnRefreshListener {
                findBankStatement()
            }
        }
    }

    private fun findBankStatement() {
        accountHolderId?.id?.let { id ->
            viewModel.getBankStatement(id).observe(this) { state ->
                when (state) {
                    State.Loading -> binding.srlBankStatement.isRefreshing = true
                    is State.Success -> {
                        binding.rvBankStatement.adapter =
                            state.data?.let { BankStatementAdapter(it) }
                        binding.srlBankStatement.isRefreshing = false
                    }

                    is State.Error -> {
                        state.message?.let { messageError ->
                            Snackbar.make(
                                binding.rvBankStatement,
                                messageError,
                                Snackbar.LENGTH_LONG
                            ).show()
                        }
                        binding.srlBankStatement.isRefreshing = false
                    }
                }
            }
        }
    }

    companion object {
        const val EXTRA_ACCOUNT_HOLDER = "com.example.bankline.ui.statement.EXTRA_ACCOUNT_HOLDER"
    }
}