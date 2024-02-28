package com.example.bankline.ui.menu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankline.databinding.MenuInitialItemBinding
import com.example.bankline.domain.MenuItem

class MenuAdapter(
    private val menuItens: List<MenuItem>,
    var onClickItem: (menuItemPosition: Int) -> Unit = {}
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: MenuInitialItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MenuItem) =
            with(binding) {
                itemView.setOnClickListener {  onClickItem(item.posicao)}
                tvMenuDescription.text = item.descricao
                ivIcon.setImageResource(item.icone)
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            MenuInitialItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = menuItens[position]
        viewHolder.bind(item)
    }

    override fun getItemCount() = menuItens.size

}