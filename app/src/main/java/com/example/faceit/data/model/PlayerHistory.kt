package com.example.faceit.data.model


import com.google.gson.annotations.SerializedName

data class PlayerHistory(
    @SerializedName("items")
    val items: List<Item>
)


data class Item(
    @SerializedName("match_id")
    val matchId: String
)
