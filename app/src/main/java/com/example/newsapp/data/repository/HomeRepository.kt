package com.example.shopingapp.data.repository

import com.example.newsapp.data.model.Article
import com.example.shopingapp.api.SafeAPIRequest
import com.example.shopingapp.api.WebServiceInterface
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HomeRepository@Inject constructor(
    private var webServiceInterface: WebServiceInterface
) : SafeAPIRequest() {

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        webServiceInterface = retrofit.create(WebServiceInterface::class.java)
    }

    suspend fun getNews(): List<Article> {
        val response = webServiceInterface.getNews("IT", "2023-05-27", "publishedAt", "a6dcb214eb204e61ab5cea48eefcc62d")
        return response.articles
    }
}