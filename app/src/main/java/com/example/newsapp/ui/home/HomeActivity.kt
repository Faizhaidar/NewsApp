package com.example.shopingapp.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseActivity
import com.example.shopingapp.databinding.ActivityHomeBinding
import com.example.shopingapp.databinding.NavHeaderHomeBinding
import javax.inject.Inject

class HomeActivity : BaseActivity() {


    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var navViewHeaderBinding: NavHeaderHomeBinding? = null

    private lateinit var binding: ActivityHomeBinding

    @Inject
    lateinit var viewmodel: HomeActivityViewModel
    override fun layoutId(): Int = R.layout.activity_login


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolBar)
        setNavigation()
        setNavigationHeader()
    }

    companion object {
        @JvmStatic
        fun intentFor(context: Context) =
            Intent(
                context,
                HomeActivity::class.java
            ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(binding.drawerLayout) || super.onSupportNavigateUp()
    }

    private fun setNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
            ), binding.drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navigationDrawer.setupWithNavController(navController)
    }

    private fun setNavigationHeader() {
        //Setting burger menu header name.
        val viewHeader = binding.navigationDrawer.getHeaderView(0)
        navViewHeaderBinding = NavHeaderHomeBinding.bind(viewHeader)


    }






}