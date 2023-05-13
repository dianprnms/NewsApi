package com.example.newsapi.viewmodel

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapi.model.ResponseDataSource
import com.example.newsapi.model.Source
import com.example.newsapi.network.NetworkClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SourceViewModel : ViewModel() {

    lateinit var liveDataSource : MutableLiveData<List<Source>?>

    init {
        liveDataSource = MutableLiveData()
    }

    fun getDataSource(): MutableLiveData<List<Source>?> {
        return  liveDataSource
    }

    fun callApiSource(category : String){
        NetworkClient.instance.getAllSources(category)
            .enqueue(object : Callback<ResponseDataSource>{
                override fun onResponse(
                    call: Call<ResponseDataSource>,
                    response: Response<ResponseDataSource>
                ) {
                    if (response.isSuccessful){
                        liveDataSource.postValue(response.body()!!.sources)
                        Log.d(TAG, "onResponse: ${response.body()!!.sources.size}")

                    }else{
                        Log.d(TAG, "onResponse: Unsuccessfully")
                        liveDataSource.postValue(null)                    }
                }

                override fun onFailure(call: Call<ResponseDataSource>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                    liveDataSource.postValue(null)                }


            })
    }

}