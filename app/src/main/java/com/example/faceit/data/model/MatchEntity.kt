package com.example.faceit.data.model

data class MatchEntity (
        val date: Long,
        val map: String,
        val score: String,
        val winner: Boolean,
        val kills: Int,
        val deaths: Int,
        val assists: Int,
        val kd: Double
        )
