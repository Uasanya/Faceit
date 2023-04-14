package com.example.faceit.data.model

import com.google.gson.annotations.SerializedName

data class Player (
        @SerializedName("player_id")
        val playerId: String,
        )