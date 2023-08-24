package com.example.faceit.di

import com.example.faceit.data.datasource.MatchRemoteDataSource
import com.example.faceit.data.datasource.PlayerRemoteDataSource
import com.example.faceit.data.repository.MatchRepository
import com.example.faceit.data.repository.PlayerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [NetworkModule::class, DataSourceModule::class])
class RepositoryModule {


    @Singleton
    @Provides
    fun provideMatchRepository(matchRemoteDataSource: MatchRemoteDataSource, playerRepository: PlayerRepository) = MatchRepository(matchRemoteDataSource, playerRepository)

    @Singleton
    @Provides
    fun providePlayerRepository(playerRemoteDataSource: PlayerRemoteDataSource) = PlayerRepository(playerRemoteDataSource)
}