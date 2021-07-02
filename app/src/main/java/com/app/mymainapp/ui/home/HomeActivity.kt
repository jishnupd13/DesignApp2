package com.app.mymainapp.ui.home

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.app.mymainapp.R
import com.app.mymainapp.databinding.ActivityHomeBinding
import com.app.mymainapp.listeners.ActivityListeners
import com.app.mymainapp.ui.account.AccountFragment
import com.app.mymainapp.ui.credit.CreditFragment
import com.app.mymainapp.ui.delivery.DeliveryFragment
import com.app.mymainapp.viewmodels.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), View.OnClickListener,
    BottomNavigationView.OnNavigationItemSelectedListener,ActivityListeners {

    private val binding: ActivityHomeBinding by viewBinding()
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.listener = this
        binding.viewModel = homeViewModel
        loadFragment(DeliveryFragment(this))
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.layoutOptions,binding.textCallHelpDesk,binding.textTermsAndPrivacy->{
                binding.layoutOptions.visibility=View.GONE
                binding.bottomNavigationView.visibility=View.VISIBLE
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.delivery -> {
                fragment = DeliveryFragment(this)
            }

            R.id.account -> {
                fragment = AccountFragment()
            }

            R.id.credit -> {
                fragment = CreditFragment()
            }
        }
        return loadFragment(fragment)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(binding.layoutContainer.id, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun visibleOptions() {
        binding.layoutOptions.visibility=View.VISIBLE
        binding.bottomNavigationView.visibility=View.GONE
    }

    override fun invisibleOptions() {
        binding.layoutOptions.visibility=View.GONE
    }
}