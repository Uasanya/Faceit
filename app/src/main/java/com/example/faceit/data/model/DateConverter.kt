package com.example.faceit.data.model


import java.text.SimpleDateFormat
import java.util.Locale

class DateConverter {

    companion object {
        private val simpleDateFormat = SimpleDateFormat("MMM dd yyyy HH:mm", Locale.ENGLISH )
        fun convert(unixDate: Long): String = simpleDateFormat.format(unixDate * 1000L)
   }


}