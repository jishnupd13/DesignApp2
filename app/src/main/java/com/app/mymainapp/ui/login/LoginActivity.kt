package com.app.mymainapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.app.mymainapp.databinding.ActivityLoginBinding
import com.app.mymainapp.ui.home.HomeActivity
import com.app.mymainapp.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityLoginBinding by viewBinding()
    private val loginViewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = loginViewModel
        binding.listener = this
/*
        loginViewModel.usernameLiveData.observe(this, Observer {

            Log.e("live","${it}")
        })*/
    }

    override fun onClick(view: View?) {

        when(view){
            binding.btnSignIn->{
                val  homeIntent=Intent(this,HomeActivity::class.java)
                startActivity(homeIntent)
                finish()
                overridePendingTransition(0,0)
            }
        }
    }
}