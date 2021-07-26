package com.example.harajtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harajtask.Adapter.DataAdapter
import com.example.harajtask.Factories.DataFactory
import com.example.harajtask.ViewModel.DataViewModel1
import com.example.harajtask.databinding.ActivityMainBinding
import com.example.harajtask.model.Root
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName
    lateinit var binding:ActivityMainBinding
    val list  = ArrayList<Root>()
    lateinit var adapter:DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val layoutManager = LinearLayoutManager(this)
        binding.recyclers.layoutManager = layoutManager
        adapter = DataAdapter(this,list)
        binding.recyclers.adapter = adapter

        val dataFactory = DataFactory(this)
        val dataViewModel1 = ViewModelProvider(this,dataFactory).get(DataViewModel1::class.java)



        dataViewModel1.getMutableData().observe(this, Observer {
            Log.i(TAG,it.size.toString()+ " in main")
            list.addAll(it)
            adapter.notifyDataSetChanged()
        })



    }
}