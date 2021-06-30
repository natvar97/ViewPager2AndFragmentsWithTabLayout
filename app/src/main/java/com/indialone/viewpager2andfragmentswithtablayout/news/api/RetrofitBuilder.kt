package com.indialone.viewpager2andfragmentswithtablayout.news.api

import com.indialone.viewpager2andfragmentswithtablayout.news.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val newsApiService = getInstance().create(NewsApiService::class.java)

}