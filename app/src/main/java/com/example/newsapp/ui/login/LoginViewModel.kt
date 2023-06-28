package com.example.newsapp.ui.login

import android.text.Editable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopingapp.MyApplication
import com.example.shopingapp.R
import com.example.shopingapp.api.ApiExceptions
import com.example.shopingapp.api.NoInternetException
import com.example.shopingapp.utils.Coroutines
import com.example.shopingapp.utils.toast
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val application: MyApplication,
) : AndroidViewModel(application) {

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> get() = _isViewLoading


    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> get() = _userName

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password


    fun onUerNameChange(editable: Editable?) {
        _userName.postValue(editable.toString())
    }

    fun onPasswrodChange(editable: Editable?) {
        _password.postValue(editable.toString())
    }

    fun checkCredentials(username: String, password: String): Boolean {
        return username == "test@android.com" && password == "123456"
    }

}