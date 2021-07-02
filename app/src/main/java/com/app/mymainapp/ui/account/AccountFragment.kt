package com.app.mymainapp.ui.account

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.app.mymainapp.R
import com.app.mymainapp.databinding.FragmentAccountBinding
import com.app.mymainapp.databinding.FragmentCreditBinding
import com.app.mymainapp.viewmodels.AccountViewModel
import com.app.mymainapp.viewmodels.CreditViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AccountFragment : Fragment(R.layout.fragment_account) ,View.OnClickListener{

    private val binding: FragmentAccountBinding by viewBinding()
    private val accountViewModel: AccountViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listener=this
        binding.viewModel=accountViewModel
    }

    override fun onClick(view: View?) {

    }
}