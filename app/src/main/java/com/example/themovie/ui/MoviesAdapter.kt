package com.example.themovie.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themovie.R
import com.example.data.utils.Constants
import com.example.domain.model.MovieEntity

class MoviesAdapter(private val movies: List<MovieEntity>,
                    private val onClickListener: View.OnClickListener): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, onClickListener)
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textViewTitle)

        fun bind(movie: MovieEntity, onClickListener: View.OnClickListener) {
            itemView.setOnClickListener(onClickListener)
            itemView.tag = movie
            textView.text = movie.name
            Glide.with(itemView.context)
                .load(Constants.BASE_IMAGE_URL+movie.poster)
                .into(imageView)
        }
    }
}
