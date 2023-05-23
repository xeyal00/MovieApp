package com.xeyalrecebli.movieapp.api


import com.xeyalrecebli.movieapp.model.Results
import org.w3c.dom.Comment
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("movie/popular")
    fun getNews(@Query("id")id:String): Call<Results?>?
    @GET("movie")
   fun getComments(@Query("id")id:String): Call<List<Comment?>?>?
}