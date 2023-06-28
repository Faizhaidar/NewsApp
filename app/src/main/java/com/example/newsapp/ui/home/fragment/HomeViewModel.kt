package com.example.shopingapp.ui.home.fragment

import android.text.format.DateUtils
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.model.NewsResponse
import com.example.shopingapp.MyApplication
import com.example.shopingapp.data.repository.HomeRepository
import com.example.shopingapp.utils.PrefUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val application: MyApplication,
    private val repository: HomeRepository,
    private val prefUtils: PrefUtils
) : AndroidViewModel(application) {

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> get() = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError

    private val _strDate = MutableLiveData<String>()
    val strDate: LiveData<String> get() = _strDate

    private val _mDateForDisplay = MutableLiveData<String>()
    val mDateForDisplay: LiveData<String> get() = _mDateForDisplay

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> get() = _articles

    private val dateFormat = SimpleDateFormat("dd-MM-yy")


    private val _allnewsLive: MutableLiveData<Response<NewsResponse>> = MutableLiveData<Response<NewsResponse>>()
    val allnewsLive: LiveData<Response<NewsResponse>>
        get() = _allnewsLive

   /* fun fetchNews() {
        viewModelScope.launch(Dispatchers.IO) {
            val news = repository.getNews()
            _articles.postValue(news)
        }
    }*/

    suspend fun newsDetails() {
        val response = repository.callNewsDetails(_strDate.value.toString())
            _allnewsLive.value = response
    }
    fun setSelectedDate(strDate: String) {
        _strDate.postValue(strDate)
        _mDateForDisplay.postValue(strDate)

        //If select current date then show Today else show formated date
        val date: Date = dateFormat.parse(strDate)
        val c = Calendar.getInstance()
        c.time = date
        c.add(Calendar.DATE, 0)
        val strDate:String = dateFormat.format(date)
        if(DateUtils.isToday(c.timeInMillis)) {
            _mDateForDisplay.postValue("Today")
        } else  {
            _mDateForDisplay.postValue(strDate)
        }
    }


}
