package com.example.faceit.data.datasource


import com.example.faceit.data.model.MatchDetails
import com.example.faceit.data.model.MatchStats
import com.example.faceit.data.network.MatchApi
import javax.inject.Inject


class MatchRemoteDataSource @Inject constructor (private val matchApi: MatchApi) {

    suspend fun getMatchDetails(matchId: String): MatchDetails = matchApi.getMatchDetails(matchId)

    suspend fun getMatchStats(matchId: String): MatchStats = matchApi.getMatchStats(matchId)
}