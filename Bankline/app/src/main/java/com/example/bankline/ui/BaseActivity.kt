package com.example.bankline.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.viewbinding.ViewBinding
import com.example.bankline.domain.Correntista
import com.example.bankline.ui.statement.BankStatementActivity

abstract class BaseActivity<VB : ViewBinding> () :
    AppCompatActivity() {
    protected abstract val binding: VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}

