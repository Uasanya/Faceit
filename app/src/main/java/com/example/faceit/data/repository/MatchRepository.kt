package com.example.faceit.data.repository


import com.example.faceit.data.datasource.MatchRemoteDataSource
import com.example.faceit.data.model.MatchDetails
import com.example.faceit.data.model.MatchEntity
import com.example.faceit.data.model.MatchStats
import com.example.faceit.data.model.PlayerStats
import javax.inject.Inject


class MatchRepository @Inject constructor(private val matchRemoteDataSource: MatchRemoteDataSource, private val playerRepository: PlayerRepository) {


    private suspend fun loadMatchDetails(matchId: String): MatchDetails =
        matchRemoteDataSource.getMatchDetails(matchId)

    private suspend fun loadMatchStats(matchId: String): MatchStats =
        matchRemoteDataSource.getMatchStats(matchId)

    suspend fun getMatchEntity(nickname:String): List<MatchEntity>{
        val listMatchEntity: MutableList<MatchEntity> = mutableListOf()
        val player =
            playerRepository.loadPlayer(nickname) // получили ответ с сервреа, в котором нам нужен айди игрока
        val playerHistory =
            playerRepository.loadPlayerHistory(player.playerId) // получааем по айди игрока историю из 20 матчей
        val playerMatches = playerHistory.items//получил список из 20 айтемов
        playerMatches.forEach { item ->
            item.matchId
            val matchId = item.matchId
            val matchDetails = loadMatchDetails(matchId)
            val matchStats = loadMatchStats(matchId)
            val date = matchDetails.date
            val rounds = matchStats.rounds
            val roundStats = rounds.first().roundStats
            val map = roundStats.map
            val score = roundStats.score
            val teams = rounds.first().teams
            var winner = false
            var playerStats: PlayerStats? = null
            teams.forEach teams@{ team ->
                team.players.forEach { teamPlayer ->
                    if (teamPlayer.playerId == player.playerId) {
                        playerStats = teamPlayer.playerStats
                        winner = team.teamId == roundStats.winner
                        return@teams
                    }
                }
            }
            val matchEntity = MatchEntity(
                date,
                map,
                score,
                winner,
                playerStats?.kills ?: -1,
                playerStats?.deaths ?: -1,
                playerStats?.assists ?: -1,
                playerStats?.kd ?: -1.0
            )
            listMatchEntity.add(matchEntity)
        }
        return listMatchEntity
    }
}