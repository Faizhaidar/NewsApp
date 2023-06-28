package com.example.shopingapp.ui.home

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopingapp.MyApplication
import com.example.shopingapp.utils.GlobalMethods
import javax.inject.Inject

class HomeActivityViewModel @Inject constructor(
    private val application: MyApplication,
    private val globalMethods: GlobalMethods
) : AndroidViewModel(application) {

}