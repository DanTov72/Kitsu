package com.example.kitsu.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.kitsu.databinding.ItemAnimeBinding
import com.example.kitsu.models.anime.AnimeModel

class AnimeAdapter(private val list: ArrayList<AnimeModel>) :
    RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder =
        AnimeViewHolder(
            ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    class AnimeViewHolder(private val binding: ItemAnimeBinding) : ViewHolder(binding.root) {

        fun onBind(model: AnimeModel) {
            binding.imageViewAnimePicture.load(model.attributes.posterImage.mediumImage)
            binding.textViewAnimeTitle.text = model.attributes.titles
        }
    }

    fun addNewItem(animeModel: List<AnimeModel>) {
        list.addAll(animeModel)
        notifyDataSetChanged()
    }
}