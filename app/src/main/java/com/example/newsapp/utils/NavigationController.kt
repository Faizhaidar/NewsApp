package com.example.shopingapp.utils

import android.app.Activity
import android.content.Context
import com.example.shopingapp.base.BaseActivity
import com.example.shopingapp.ui.home.HomeActivity
import javax.inject.Inject

/**
 * Class That Handles all Navigation between Activities
 */
class NavigationController @Inject constructor(var context: Context) {
    fun navigateToHome(
        activity: BaseActivity
    ) {
        activity.startActivity(HomeActivity.intentFor(context))
    }
}