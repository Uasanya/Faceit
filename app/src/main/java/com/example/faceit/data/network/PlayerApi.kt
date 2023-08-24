package com.example.faceit.data.network

import com.example.faceit.data.model.Player
import com.example.faceit.data.model.PlayerHistory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlayerApi {

    //получаем никнейм для того что бы узнать айди плеера
    @GET("players")
    suspend fun getPlayer(@Query("nickname") nickname: String): Player

    //по айди плеера полученого по никнейму получаем истоию последних 20 матчей
    @GET("players/{player_id}/history?game=csgo")
    suspend fun getPlayerHistory(@Path("player_id") playerId: String): PlayerHistory
}