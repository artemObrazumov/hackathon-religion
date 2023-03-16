package com.borsch_team.hackathonReligion.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.borsch_team.hackathonReligion.data.models.FilmModel
import com.borsch_team.hackathonReligion.databinding.ActivityMainBinding
import com.borsch_team.hackathonReligion.databinding.ItemFilmBinding
import com.bumptech.glide.Glide

class FilmsAdapter(private val clickedItem: (item: FilmModel) -> Unit):
    RecyclerView.Adapter<FilmsAdapter.ViewHolder>(){

    private var dataList = emptyList<FilmModel>()

    @SuppressLint("NotifyDataSetChanged")
    internal fun setDataList(dataList: ArrayList<FilmModel>){
        this.dataList = dataList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemFilmBinding, private val clickedItem: (model: FilmModel) -> Unit):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(filmModel: FilmModel) {
            binding.itemFilmTvName.text = filmModel.name
            binding.itemFilmTvDuration.text = filmModel.duration
            Glide
                .with(binding.root)
                .load(filmModel.src_preview_video)
                .into(binding.itemFilmImgFilm);
            binding.root.setOnClickListener{clickedItem(filmModel)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemFilmBinding
                .inflate(LayoutInflater.from(parent.context), parent, false), clickedItem
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}