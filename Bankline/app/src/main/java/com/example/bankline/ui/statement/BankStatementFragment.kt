package com.example.bankline.ui.statement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankline.data.State
import com.example.bankline.databinding.FragmentBankStatementBinding
import com.example.bankline.ui.statement.adapter.BankStatementAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BankStatementFragment : Fragment() {

    private var _binding: FragmentBankStatementBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BankSatementViewModel by viewModels()

    private val accountHolder by navArgs<BankStatementFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBankStatementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
        findBankStatement()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setViews() {
        with(binding) {
            rvBankStatement.layoutManager = LinearLayoutManager(context)
            srlBankStatement.setOnRefreshListener {
                findBankStatement()
            }
        }
    }

    private fun findBankStatement() {
        accountHolder.id.let {
            viewModel.findBankStatement(id).observe(viewLifecycleOwner) { state ->
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
}