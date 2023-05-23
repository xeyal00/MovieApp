package com.xeyalrecebli.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.xeyalrecebli.movieapp.adapter.Adapter
import com.xeyalrecebli.movieapp.databinding.ActivityMainBinding
import com.xeyalrecebli.movieapp.model.Results
import network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ryc.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        getNews()
    }
    fun getNews(){
        val call: Call<Results?>? = RetrofitClient.getRetrofitInstance()?.getApi()?.getNews("25")
        call?.enqueue(object : Callback<Results?> {
            override fun onResponse(call: Call<Results?>?, response: Response<Results?>?) {
                val newsList: Results = response?.body() as Results
                binding.ryc.adapter = Adapter(newsList.results)
            }
            override fun onFailure(call: Call<Results?>?, t: Throwable?) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
}