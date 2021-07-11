package com.app.mymainapp.ui.termsandcondition

import android.os.Bundle
import android.view.View
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.app.mymainapp.databinding.ActivityTermsAndConditionsBinding
import com.app.mymainapp.viewmodels.TermsAndConditionsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TermsAndConditionsActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityTermsAndConditionsBinding by viewBinding()
    private val termsAndConditionsViewModel: TermsAndConditionsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.listener = this
        binding.viewModel = termsAndConditionsViewModel
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.imageBack -> {
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        finish()
        overridePendingTransition(0, 0)
    }
}