package com.example.newsapi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapi.R
import com.example.newsapi.databinding.ActivityCategoryBinding
import com.example.newsapi.model.CategoryData
import com.example.newsapi.view.adapter.CategoryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding
    private lateinit var categoryAdapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listCategory = arrayListOf(
            CategoryData("BUSINESS",R.drawable.gambarr),
            CategoryData("ENTERTAINMENT",R.drawable.gambarr),
            CategoryData("GENERAL",R.drawable.gambarr),
            CategoryData("HEALTH",R.drawable.gambarr),
            CategoryData("SCIENCE",R.drawable.gambarr),
            CategoryData("SPORTS",R.drawable.gambarr),
            CategoryData("TECHNOLOGY",R.drawable.gambarr)
        )

        categoryAdapter = CategoryAdapter(listCategory)
        binding.rvCategory.apply {
            layoutManager = LinearLayoutManager(this@CategoryActivity, LinearLayoutManager.VERTICAL, false)
            adapter = categoryAdapter
            categoryAdapter.onClick={
                val categ = it.name
                val inten = Intent(context, SourceActivity::class.java)
                inten.putExtra("name", categ)
                startActivity(inten)
            }
        }

    }
}