package com.example.faceit.data.datasource

import com.example.faceit.data.model.Player
import com.example.faceit.data.model.PlayerHistory
import com.example.faceit.data.network.PlayerApi
import javax.inject.Inject


class PlayerRemoteDataSource @Inject constructor (private val playerApi:PlayerApi) {

    suspend fun getPlayer(nickname: String): Player = playerApi.getPlayer(nickname)

    suspend fun getPlayerHistory(playerId: String): PlayerHistory = playerApi.getPlayerHistory(playerId)
}