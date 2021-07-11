package com.app.mymainapp.ui.delivery

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.app.mymainapp.databinding.ActivityOrderDetailsBinding
import com.app.mymainapp.viewmodels.OrderDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderDetailsActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityOrderDetailsBinding by viewBinding()
    private val deliveryViewModel: OrderDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.listener = this
        binding.viewModel = deliveryViewModel
    }

    override fun onClick(view: View?) {

        when (view) {
            binding.imageBack -> {
                onBackPressed()
            }
            binding.btnReturnItem -> {
                val orderIntent = Intent(this, ReturnItemActivity::class.java)
                startActivity(orderIntent)
                overridePendingTransition(0, 0)
            }
        }
    }

    override fun onBackPressed() {
        finish()
        overridePendingTransition(0, 0)
    }
}