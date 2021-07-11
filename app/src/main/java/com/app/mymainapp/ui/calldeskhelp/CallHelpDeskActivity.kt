package com.app.mymainapp.ui.calldeskhelp

import android.os.Bundle
import android.view.View
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.app.mymainapp.databinding.ActivityCallHelpDeskBinding
import com.app.mymainapp.viewmodels.CallHelpDeskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CallHelpDeskActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityCallHelpDeskBinding by viewBinding()
    private val callHelpDeskViewModel: CallHelpDeskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.listener = this
        binding.viewModel = callHelpDeskViewModel
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