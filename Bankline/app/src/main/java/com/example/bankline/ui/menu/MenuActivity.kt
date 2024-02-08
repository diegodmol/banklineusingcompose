package com.example.bankline.ui.menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bankline.R
import com.example.bankline.databinding.ActivityMenuBinding
import com.example.bankline.domain.MenuItem
import com.example.bankline.ui.menu.adapter.MenuAdapter
import com.example.bankline.ui.welcome.WelcomeActivity

class MenuActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMenuBinding.inflate(layoutInflater)
    }

    private val adapter = MenuAdapter(
        dataSet = setMenuItem()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setViews()
        setListeners()
    }

    private fun setListeners() {
        with(binding) {
            rvMenu.adapter.apply {

            }
        }
    }

    private fun setViews() {
        with(binding) {
            rvMenu.layoutManager = GridLayoutManager(this@MenuActivity, 2)
            val recyclerView = binding.rvMenu
            recyclerView.adapter = adapter
            adapter.onClickItem = {
                redirectFlow(it)
            }
        }
    }

    private fun redirectFlow(flow: Int) {
        when (flow) {
            0 -> {
                val navigate = Intent(this, WelcomeActivity::class.java)
                startActivity(navigate)
                }
            }
        }

    private fun setMenuItem(): List<MenuItem> {
        val dataSet = ArrayList<MenuItem>()
        dataSet.add(MenuItem(R.drawable.ic_money_out, "Correntista", 0))
        dataSet.add(MenuItem(R.drawable.ic_holder_user, "Correntista", 1))
        dataSet.add(MenuItem(R.drawable.ic_money_out, "Correntista", 2))
        dataSet.add(MenuItem(R.drawable.ic_money_out, "Correntista", 3))
        return dataSet
    }
}