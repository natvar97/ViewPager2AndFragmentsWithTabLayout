package com.indialone.viewpager2andfragmentswithtablayout.news.repository

import androidx.annotation.WorkerThread
import com.indialone.viewpager2andfragmentswithtablayout.news.api.RetrofitBuilder
import com.indialone.viewpager2andfragmentswithtablayout.news.utils.Constants

class NewsRepository {

    @WorkerThread
    suspend fun getTopHeadlines() = RetrofitBuilder.newsApiService
        .getTopHeadlines(
            Constants.COUNTRY,
            Constants.CATEGORY,
            Constants.API_KEY
        )


    @WorkerThread
    suspend fun getTechCrunchNews() = RetrofitBuilder.newsApiService
        .getTechCrunchNews(
            Constants.SOURCES,
            Constants.API_KEY
        )


    @WorkerThread
    suspend fun getAppleNews() = RetrofitBuilder.newsApiService
        .getAppleNews(
            Constants.Q_APPLE,
            Constants.FROM_APPLE,
            Constants.TO_APPLE,
            Constants.SORT_BY_APPLE,
            Constants.API_KEY
        )

    @WorkerThread
    suspend fun getTeslaNews() = RetrofitBuilder.newsApiService
        .getTeslaNews(
            Constants.Q_TESLA,
            Constants.FROM,
            Constants.SORT_BY,
            Constants.API_KEY
        )


    @WorkerThread
    suspend fun getWsjComNews() = RetrofitBuilder.newsApiService
        .getWsjComNews(
            Constants.DOMAINS,
            Constants.API_KEY
        )

}