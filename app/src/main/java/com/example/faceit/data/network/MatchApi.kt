package com.example.faceit.data.network

import com.example.faceit.data.model.MatchDetails
import com.example.faceit.data.model.MatchStats
import retrofit2.http.GET
import retrofit2.http.Path

interface MatchApi {

    //по матч айди получаем время(нужно уже для статистики) и команду победителя(потом будем проверять есть ли я в этой команде)
    @GET("matches/{match_id}")
    suspend fun getMatchDetails(@Path("match_id") matchId: String): MatchDetails

    //получаем список раундс, из которого будем доставать раундстатс и команды, из раундстатс достаем карту и счёт, из команды получаем список игроков и стату
    //по плеер айди ищем искомого игрока и получаем плеер статс
    @GET("matches/{match_id}/stats")
    suspend fun getMatchStats(@Path("match_id") matchId: String) : MatchStats
}