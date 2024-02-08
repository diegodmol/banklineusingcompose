package com.example.bankline.ui.welcome

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.bankline.databinding.ActivityWelcomeBinding
import com.example.bankline.domain.Correntista
import com.example.bankline.ui.statement.BankStatementActivity
import com.example.bankline.ui.statement.BankStatementActivity.Companion.EXTRA_ACCOUNT_HOLDER
import com.example.bankline.ui.statement.adapter.BankStatementAdapter

class WelcomeActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityWelcomeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setViews()
        setListeners()
    }

    private fun setListeners() {
        with(binding) {
            btnContinue.setOnClickListener {
                val accountHolderId = binding.edtIdAccount.text.toString().toInt()
                val accountHolder = Correntista(accountHolderId)

                val intent = Intent(this@WelcomeActivity, BankStatementActivity::class.java).apply {
                    putExtra(EXTRA_ACCOUNT_HOLDER, accountHolder)
                }
                startActivity(intent)
            }
        }
    }

    private fun setViews() {
        with(binding) {
            edtIdAccount.doAfterTextChanged {
                btnContinue.isEnabled = edtIdAccount.text?.isNotEmpty() ?: false
            }
        }
    }
}