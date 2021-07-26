package com.example.harajtask.Utils

import java.text.SimpleDateFormat
import java.util.*

class HELPER {

    companion object{
        fun getDate(date:Int) : String{
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-DD hh-mm-a")
            return simpleDateFormat.format(Date(date.toLong()))
        }
    }
}