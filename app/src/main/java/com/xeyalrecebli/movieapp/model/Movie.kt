package com.xeyalrecebli.movieapp.model

data class Movie(var id:String,var poster_path:String,var adult:String,var overview:String,var release_date:String,var genre_ids:List<Int>,var original_title:String,var original_language:String,var title:String,var backdrop_path:String,var popularity:String,var vote_count:String,var video:String?,var vote_average:String)
