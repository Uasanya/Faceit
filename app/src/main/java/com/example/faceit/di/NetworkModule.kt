package com.example.faceit.di

import com.example.faceit.data.network.MatchApi
import com.example.faceit.data.network.PlayerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.Interceptor.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit =
           Retrofit.Builder()
            .baseUrl("https://open.faceit.com/data/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    @Singleton
    @Provides
    fun provideOkHttpClient(headerInterceptor: Interceptor, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideLoggingInterceptor():HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideHeaderInterceptor() = Interceptor { chain ->
        val newRequest: Request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer 52b9c563-63b9-47e8-a365-5640bab53fd9")
            .build()
        chain.proceed(newRequest)
    }

    @Singleton
    @Provides
    fun providePlayerApi(retrofit: Retrofit): PlayerApi = retrofit.create(PlayerApi::class.java)

    @Singleton
    @Provides
    fun provideMatchApi(retrofit: Retrofit) : MatchApi = retrofit.create(MatchApi::class.java)

}