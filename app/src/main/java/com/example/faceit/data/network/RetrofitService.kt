package com.example.faceit.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitService{


                
    val BASE_URL: String = "https://open.faceit.com/data/v4"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
      .build()
     fun getPlayerApi(): PlayerApi = retrofit.create(PlayerApi::class.java)
     fun getMatchApi(): MatchApi = retrofit.create(MatchApi::class.java)


}
