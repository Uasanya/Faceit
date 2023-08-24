package com.example.faceit.ui.stats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faceit.data.model.MatchEntity
import com.example.faceit.data.repository.MatchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatsViewModel @Inject constructor(
    //private val playerRepository: PlayerRepository,
    private val matchRepository: MatchRepository
) : ViewModel() {

    private val _statsLiveData = MutableLiveData<List<MatchEntity>>()
    val statsLiveData: LiveData<List<MatchEntity>>
        get() = _statsLiveData

    // val a: Int = 2
    //val b:Int
    //   get() = a
    //var c: Int = 0
    //   set(value){
    //     field = value
    //}
    //var d: Int = 5
    //  private set
    //init {
    //  d = 3
    //}



    fun getStats(nickname: String) {
        viewModelScope.launch {
            try {
//                val listMatchEntity: MutableList<MatchEntity> = mutableListOf()
//                val player =
//                    playerRepository.loadPlayer(nickname) // получили ответ с сервреа, в котором нам нужен айди игрока
//                val playerHistory =
//                    playerRepository.loadPlayerHistory(player.playerId) // получааем по айди игрока историю из 20 матчей
//                val playerMatches = playerHistory.items//получил список из 20 айтемов
//                playerMatches.forEach { item ->
//                    item.matchId
//                    val matchId = item.matchId
//                    val matchDetails = matchRepository.loadMatchDetails(matchId)
//                    val matchStats = matchRepository.loadMatchStats(matchId)
//                    val date = matchDetails.date
//                    val rounds = matchStats.rounds
//                    val roundStats = rounds.first().roundStats
//                    val map = roundStats.map
//                    val score = roundStats.score
//                    val teams = rounds.first().teams
//                    var winner: Boolean = false
//                    var playerStats: PlayerStats? = null
//                    teams.forEach teams@{ team ->
//                        team.players.forEach { teamPlayer ->
//                            if (teamPlayer.playerId == player.playerId) {
//                                playerStats = teamPlayer.playerStats
//                                winner = team.teamId == roundStats.winner
//                                return@teams
//                            }
//                        }
//                    }
//                    val matchEntity = MatchEntity(
//                        date,
//                        map,
//                        score,
//                        winner,
//                        playerStats?.kills ?: -1,
//                        playerStats?.deaths ?: -1,
//                        playerStats?.assists ?: -1,
//                        playerStats?.kd ?: -1.0
//                    )
                //                 listMatchEntity.add(matchEntity)


            _statsLiveData.value = matchRepository.getMatchEntity(nickname)//listMatchEntity
        }
            catch (e: Exception) {
                e
            }
        }

    }

}


