package com.example.faceit.data.repository

import com.example.faceit.data.datasource.PlayerRemoteDataSource
import com.example.faceit.data.model.Player
import com.example.faceit.data.model.PlayerHistory
import javax.inject.Inject


class PlayerRepository @Inject constructor (private val playerRemoteDataSource: PlayerRemoteDataSource) {

    //private val remoteDatasource: PlayerRemoteDataSource = PlayerRemoteDataSource()

    suspend fun loadPlayer(nickname: String) : Player =
        playerRemoteDataSource.getPlayer(nickname)

    suspend fun  loadPlayerHistory(playerId: String) : PlayerHistory =
        playerRemoteDataSource.getPlayerHistory(playerId)


}