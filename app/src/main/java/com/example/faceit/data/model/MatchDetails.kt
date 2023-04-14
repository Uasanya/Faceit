package com.example.faceit.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class MatchDetails(
    @SerializedName("started_at")
    val date: Long,
    @SerializedName("results")
    val result: Result
    )

data class Result(
    @SerializedName("winner")
    val winner: String
)