package com.example.faceit.data.model

import com.google.gson.annotations.SerializedName

data class MatchStats(
    @SerializedName("rounds")
    val rounds: List<Rounds>
)

data class Rounds(
    @SerializedName("round_stats")
    val roundStats: RoundStats,
    @SerializedName("teams")
    val teams: List<Team>
)

data class RoundStats(
    @SerializedName("Map")
    val map: String,
    @SerializedName("Score")
    val score: String

)

data class Team(
    @SerializedName("players")
    val players: List<TeamPlayer>
)

data class TeamPlayer(
    @SerializedName("player_id")
    val playerId: String,
    @SerializedName("player_stats")
    val playerStats: List<PlayerStats>
)
data class PlayerStats(
    @SerializedName("Kills")
    val kills: Int,
    @SerializedName("Deaths")
    val deaths: Int,
    @SerializedName("Assists")
    val assists: Int,
    @SerializedName("K/D Ratio")
    val kd: Double
)
