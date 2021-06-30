package com.indialone.viewpager2andfragmentswithtablayout.news.api

import com.indialone.viewpager2andfragmentswithtablayout.news.model.NewsEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): NewsEntity


    @GET("top-headlines")
    suspend fun getTechCrunchNews(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String
    ): NewsEntity

    @GET("everything")
    suspend fun getTeslaNews(
        @Query("q") q: String,
        @Query("from") from: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): NewsEntity


    @GET("everything")
    suspend fun getAppleNews(
        @Query("q") q: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): NewsEntity

    @GET("everything")
    suspend fun getWsjComNews(
        @Query("domains") domains: String,
        @Query("apiKey") apiKey: String
    ): NewsEntity

}