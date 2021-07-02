package com.app.mymainapp.ui.credit

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.app.mymainapp.R
import com.app.mymainapp.databinding.FragmentCreditBinding
import com.app.mymainapp.viewmodels.CreditViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreditFragment : Fragment(R.layout.fragment_credit), View.OnClickListener {

    private val binding: FragmentCreditBinding by viewBinding()
    private val creditViewModel: CreditViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listener = this
        binding.viewModel = creditViewModel
    }

    override fun onClick(view: View?) {

    }


}