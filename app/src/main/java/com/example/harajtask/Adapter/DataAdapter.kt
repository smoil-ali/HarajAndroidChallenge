package com.example.harajtask.Adapter

import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.InfoActivity
import com.example.harajtask.R
import com.example.harajtask.Utils.HELPER
import com.example.harajtask.databinding.ItemDataBinding
import com.example.harajtask.model.Root
import com.squareup.picasso.Picasso

class DataAdapter(val context: Context,val list: List<Root>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    val TAG = DataAdapter::class.java.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:ItemDataBinding = ItemDataBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val root = list.get(position)
        holder.binding.title.text = root.title
        Picasso.get().load(root.thumbURL).placeholder(R.drawable.car).into(holder.binding.image)
        holder.binding.cityName.text = root.city
        holder.binding.time.text = HELPER.getDate(root.date)
        if (root.commentCount == 0)
            holder.binding.commentContainer.visibility = View.INVISIBLE
        else{
            holder.binding.commentContainer.visibility = View.VISIBLE
            holder.binding.commentCount.text = "("+root.commentCount.toString()+")"
        }
        holder.binding.userName.text = root.username

        holder.binding.container.setOnClickListener {
            val intent = Intent(context,InfoActivity::class.java)
            intent.putExtra("Data",root)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root)
}