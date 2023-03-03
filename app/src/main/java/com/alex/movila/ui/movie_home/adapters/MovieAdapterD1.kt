package com.alex.movila.ui.movie_home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alex.movila.R
import com.alex.movila.domain.model.PopularMoviesUI
import com.bumptech.glide.Glide

class MovieAdapterD1 (private val onClickListener: (String)->Unit):RecyclerView.Adapter<MovieAdapterD1.MovieHolder>() {

    private var movies: List<PopularMoviesUI> = mutableListOf()
    inner class MovieHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.ivMovieRecyclerViewD1)

        fun bind(movie: PopularMoviesUI, onClickListener: (String) -> Unit){
            Glide.with(itemView.context)
                .load(movie.imageUrl)
                .into(itemImage)
            itemImage.setOnClickListener {
                onClickListener(movie.id)
            }
        }
    }

    fun submit(imageList: List<PopularMoviesUI>){
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