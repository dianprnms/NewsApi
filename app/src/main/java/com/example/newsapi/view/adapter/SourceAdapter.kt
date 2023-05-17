package com.example.newsapi.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapi.databinding.ItemSourceBinding
import com.example.newsapi.model.Source

@Suppress("unused")
class SourceAdapter(private var listSource : List<Source>):RecyclerView.Adapter<SourceAdapter.ViewHolder>() {

    private var onClick : ((Source) -> Unit)? = null


    class ViewHolder(var binding : ItemSourceBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSourceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val source = listSource[position]
        if (source != null){
        holder.binding.nameSource.text = source.name
        holder.binding.itemSource.setOnClickListener {
            onClick?.invoke(listSource[position])
        }
        }
    }

    override fun getItemCount(): Int {
        return  listSource.size
    }
}