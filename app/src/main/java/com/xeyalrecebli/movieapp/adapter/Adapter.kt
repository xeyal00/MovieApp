package com.xeyalrecebli.movieapp.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.xeyalrecebli.movieapp.R
import com.xeyalrecebli.movieapp.model.Movie

class Adapter(list:List<Movie>): RecyclerView.Adapter<Adapter.ViewHolder>() {
  var list:List<Movie>
  init {
      this.list=list
  }

    inner class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        var title=itemview.findViewById<TextView>(R.id.title)
        var population=itemview.findViewById<TextView>(R.id.popularity)
        var movie=itemview.findViewById<ImageView>(R.id.movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.setText(list.get(position).title)
        holder.population.setText(list.get(position).overview)
        Picasso.get().load(list.get(position).video).resize(800, 800).centerCrop().into(holder.movie)
    }
}


