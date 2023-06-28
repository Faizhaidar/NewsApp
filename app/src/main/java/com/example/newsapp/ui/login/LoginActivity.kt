package com.example.newsapp.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingActivity
import com.example.shopingapp.databinding.ActivityLoginBinding
import com.example.shopingapp.utils.toast
import java.util.ArrayList
import javax.inject.Inject


class LoginActivity : BaseBindingActivity<ActivityLoginBinding>() {

    @Inject
    lateinit var viewModel: LoginViewModel

    override fun layoutId(): Int = R.layout.activity_login

    private var binding: ActivityLoginBinding? = null


    override fun initializeBinding(binding: ActivityLoginBinding) {
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        binding.listner = this
        this.binding = binding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val onMessageErrorObserver = Observer<Any> {
        toast(it.toString())
    }

    fun callLogin(){
        val isValid = viewModel.checkCredentials(viewModel.userName.value.toString(), viewModel.password.value.toString())
        if (isValid) {
            // Credentials are valid, to navigate to home activity
            Toast.makeText(this, "Login complate", Toast.LENGTH_SHORT).show()
            navigationController.navigateToHome(this@LoginActivity)
        } else {
            // Credentials are invalid, show an error message
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
        }

    }

}