package com.alex.movila.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.alex.movila.R

class ViewPagerMovieMainAdapter(private var imagesList:List<Int>):RecyclerView.Adapter<ViewPagerMovieMainAdapter.PagerMovieViewHolder>() {


   inner class PagerMovieViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
       val itemImage: ImageView = itemView.findViewById(R.id.ivMovieViewPager)

       init {
           itemImage.setOnClickListener {
               val position = adapterPosition
               Toast.makeText(itemView.context, "Item clicked #${position + 1}", Toast.LENGTH_SHORT).show()

           }
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerMovieViewHolder {
        return PagerMovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie_home_main_list, parent, false))
    }

    override fun onBindViewHolder(holder: PagerMovieViewHolder, position: Int) {
        holder.itemImage.setImageResource(imagesList[position])
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }
}