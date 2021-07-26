package com.example.harajtask.model

import java.io.Serializable

data class Root(val title:String,
                val thumbURL:String,
                val username:String,
                val commentCount:Int,
                val city:String,
                val date:Int,
                val body:String) : Serializable
