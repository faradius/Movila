package com.alex.movila.ui.movie_home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.alex.movila.R
import com.alex.movila.data.network.model.Movie
import com.alex.movila.data.network.model.MovieList
import com.alex.movila.utils.toMovieUrl
import com.bumptech.glide.Glide

class MovieAdapterD1 (private val onClickListener: (String)->Unit):RecyclerView.Adapter<MovieAdapterD1.MovieHolder>() {

    private var movies: List<Movie> = mutableListOf()
    inner class MovieHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.ivMovieRecyclerViewD1)

        fun bind(movie: Movie, onClickListener: (String) -> Unit){
            Glide.with(itemView.context)
                .load(movie.poster_path.toMovieUrl())
                .into(itemImage)
            itemImage.setOnClickListener {
                onClickListener(" ")
            }
        }
    }

    fun submit(imageList: List<Movie>){
        movies = imageList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie_d1, parent, false))
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movies[position],onClickListener)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}