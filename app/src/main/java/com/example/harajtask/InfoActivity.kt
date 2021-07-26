package com.example.harajtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.harajtask.Utils.HELPER
import com.example.harajtask.databinding.ActivityInfoBinding
import com.example.harajtask.model.Root
import com.squareup.picasso.Picasso

class InfoActivity : AppCompatActivity() {
    val TAG = InfoActivity::class.java.simpleName
    lateinit var root: Root
    lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        root = intent.extras?.getSerializable("Data") as Root

        Log.i(TAG,root.title)

        Picasso.get().load(root.thumbURL).placeholder(R.drawable.car).into(binding.image)
        binding.title.text = root.title
        binding.time.text = HELPER.getDate(root.date)
        binding.userName.text = root.username
        binding.cityName.text = root.city
        binding.body.text = root.body

        binding.share.setOnClickListener {
            shareTitle()
        }
    }

    fun shareTitle() : Unit{
        val intent = Intent()
        intent.setAction(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT,root.title)
        startActivity(Intent.createChooser(intent,"Share via"))
    }
}