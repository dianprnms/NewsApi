package com.example.newsapi.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapi.databinding.ActivitySourceBinding
import com.example.newsapi.view.adapter.SourceAdapter
import com.example.newsapi.viewmodel.SourceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourceActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySourceBinding
    private lateinit var sourceAdapter : SourceAdapter
    private lateinit var sourceVm : SourceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sourceVm = ViewModelProvider(this)[SourceViewModel::class.java]
        sourceAdapter = SourceAdapter(ArrayList())
        sourceVm.getDataSource().observe(this) {
            sourceAdapter = SourceAdapter(it!!)
            val layoutMan = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvSource.layoutManager = layoutMan
            binding.rvSource.adapter = sourceAdapter
        }

        val datacat = intent.extras!!.getString("name")
        sourceVm.callApiSource(datacat.toString())
    }



}