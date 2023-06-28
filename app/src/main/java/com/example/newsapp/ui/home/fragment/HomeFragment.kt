package com.example.shopingapp.ui.home.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseBindingFragment
import com.example.shopingapp.databinding.FragmentHomeBinding
import com.example.shopingapp.utils.LogM
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

class HomeFragment : BaseBindingFragment<FragmentHomeBinding>() {

    @Inject
    lateinit var viewmodel: HomeViewModel

    override fun layoutId(): Int = R.layout.fragment_home

    private var navController: NavController? = null

    private var strSelectedDate: String = ""

    override fun initializeBinding(binding: FragmentHomeBinding) {
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        binding.listner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        LogM.e("==> is articles data "+viewmodel.articles.value.toString())

        viewmodel.articles.observe(this, Observer { articles ->
            // Handle the updated list of articles here
            LogM.e("==> is data "+articles.toString())
            LogM.e("==>observer  is data "+viewmodel.articles.value.toString())

        })
        viewmodel.fetchNews()
    }

    fun pickDateTime() {
        val currentDateTime = Calendar.getInstance()
        val startYear = currentDateTime.get(Calendar.YEAR)
        val startMonth = currentDateTime.get(Calendar.MONTH)
        val startDay = currentDateTime.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { datePicker, year, month, day ->

                val month = String.format("%02d", month + 1)
                val day = String.format("%02d", day)
                val mYear = String.format("%02d", startYear)
                val finalDate: String = day + "-" + month + "-" + mYear + " "
                val inputFormat = SimpleDateFormat("dd-MM-yyyy")
                val date: Date = inputFormat.parse(finalDate)
                val  str = dateFormat.format(date);
                strSelectedDate = str
                viewmodel.setSelectedDate(strSelectedDate)

            }, startYear, startMonth, startDay
        )
        datePickerDialog.show()
    }

}