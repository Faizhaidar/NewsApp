package com.example.shopingapp.di

import com.example.newsapp.ui.login.LoginActivity
import com.example.shopingapp.ui.home.HomeActivity
import com.example.shopingapp.ui.home.fragment.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Helps to generate an {@link AndroidInjector} for all activities
 * */
@Suppress("unused")
@Module
abstract class ActivityBuilder {

    /**
     * fun to bind HomeActivity Activity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindHomeActivity() : HomeActivity

    /**
     * fun to bind HomeFragment Activity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindHomeFragment() : HomeFragment


    /**
     * fun to bind LoginActivity Activity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindLoginActivity() : LoginActivity

}