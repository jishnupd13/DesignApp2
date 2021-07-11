package com.app.mymainapp.viewmodels

import androidx.lifecycle.ViewModel
import com.app.mymainapp.repository.AppRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CallHelpDeskViewModel @Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel() {
}