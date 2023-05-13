package com.example.newsapi.view.adapter

import android.renderscript.ScriptGroup.Binding
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapi.databinding.ActivityCategoryBinding
import com.example.newsapi.databinding.ItemCategoryBinding
import com.example.newsapi.model.CategoryData

class CategoryAdapter(var listCategory: List<CategoryData>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    var onClick : ((CategoryData)->Unit)? = null

    class ViewHolder (var binding: ItemCategoryBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        var view = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return listCategory.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.categoryName.text = listCategory[position].name
        Glide.with(holder.itemView).load(listCategory[position].picture).into(holder.binding.categoryImage)
        holder.binding.itemCategory.setOnClickListener{
           onClick!!.invoke(listCategory[position])
        }


    }
}