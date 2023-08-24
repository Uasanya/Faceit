package com.example.faceit.di

import com.example.faceit.data.datasource.MatchRemoteDataSource
import com.example.faceit.data.datasource.PlayerRemoteDataSource
import com.example.faceit.data.network.MatchApi
import com.example.faceit.data.network.PlayerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideMatchRemoteDataSource(matchApi:MatchApi) = MatchRemoteDataSource(matchApi)

    @Singleton
    @Provides
    fun providePlayerRemoteDataSource(playerApi: PlayerApi) = PlayerRemoteDataSource(playerApi)

}