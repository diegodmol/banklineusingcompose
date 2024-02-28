package com.example.bankline.ui.accountholder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bankline.databinding.FragmentAccountHolderBinding
import com.example.bankline.domain.Correntista
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountHolderFragment : Fragment() {

    private var _binding: FragmentAccountHolderBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountHolderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
        setListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setListeners() {
        with(binding) {
            btnContinue.setOnClickListener {
                val accountHolderId = binding.edtIdAccount.text.toString().toInt()
                val accountHolder = Correntista(accountHolderId)
                val directions = AccountHolderFragmentDirections.actionHoldUserToStatementFragment(accountHolder)
                findNavController().navigate(directions)
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