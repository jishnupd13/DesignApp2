package com.app.mymainapp.viewmodels

import androidx.lifecycle.ViewModel
import com.app.mymainapp.repository.AppRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreditViewModel @Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel()  {
}