package com.example.harajtask.ViewModel

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.harajtask.model.Root
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.InputStream

class DataViewModel1() : ViewModel() {
    private val TAG = DataViewModel1::class.java.simpleName
    private lateinit var mutableLiveData:MutableLiveData<List<Root>>
    constructor(context: Context) : this() {
        mutableLiveData = MutableLiveData()
        val json : String
        val inputStream:InputStream = context.assets.open("data.json")
        val size : Int = inputStream.available()
        val byteArray = ByteArray(size)
        inputStream.read(byteArray)
        inputStream.close()
        json = String(byteArray,Charsets.UTF_8)
        val gson = GsonBuilder().create()
        val list = object:TypeToken<List<Root>>(){}.type
        val mList = gson.fromJson<List<Root>>(json,list)
        Log.i(TAG,mList.size.toString() + " size")
        mutableLiveData.value = mList
    }

    fun getMutableData() : MutableLiveData<List<Root>>{
        return mutableLiveData
    }




}