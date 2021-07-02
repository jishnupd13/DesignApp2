package com.app.mymainapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.mymainapp.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel  @Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel() {

    val _usernameLiveData=MutableLiveData<String>()
    val usernameLiveData:LiveData<String>
    get() = _usernameLiveData

    fun provideUsernameLiveData():LiveData<String>{
        return usernameLiveData
    }
}