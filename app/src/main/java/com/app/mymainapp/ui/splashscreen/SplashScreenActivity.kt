package com.app.mymainapp.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.app.mymainapp.databinding.ActivitySplashScreenBinding
import com.app.mymainapp.ui.login.LoginActivity
import com.app.mymainapp.viewmodels.SplashScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivitySplashScreenBinding by viewBinding()
    private val splashScreenViewModel: SplashScreenViewModel by viewModels()

    private val splashScreenTime = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = splashScreenViewModel
        binding.listener = this

        Handler(Looper.getMainLooper()).postDelayed({
            val splashScreenIntent = Intent(this, LoginActivity::class.java)
            startActivity(splashScreenIntent)
            finish()
            overridePendingTransition(0, 0)

        }, splashScreenTime)
    }

    override fun onClick(v: View?) {

    }
}