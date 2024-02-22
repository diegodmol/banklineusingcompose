package com.example.bankline.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bankline.R
import com.example.bankline.databinding.FragmentMenuBinding
import com.example.bankline.domain.MenuItem
import com.example.bankline.ui.menu.adapter.MenuAdapter

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    private val adapter = MenuAdapter(
        dataSet = setMenuItem()
    )

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setViews()
        setListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setListeners() {
        with(binding) {
            rvMenu.adapter.apply {
            }
        }
    }

    private fun setViews() {
        with(binding) {
            rvMenu.layoutManager = GridLayoutManager(context, 2)
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

            }
        }
    }

    private fun setMenuItem(): List<MenuItem> {
        val dataSet = ArrayList<MenuItem>()
        dataSet.add(MenuItem(R.drawable.ic_person, "Correntista", 0))
        dataSet.add(MenuItem(R.drawable.ic_about, "Sobre", 1))
        return dataSet
    }
}