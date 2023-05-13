package com.example.newsapi.network

import com.example.newsapi.model.ResponseDataSource
import com.example.newsapi.model.Source
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines/sources")
    fun getAllSources(
        @Query("category") category:String,
        @Query("apikey") apikey:String = "313f9c945f2b4322853651607776a10c"
    ): Call<ResponseDataSource>
}