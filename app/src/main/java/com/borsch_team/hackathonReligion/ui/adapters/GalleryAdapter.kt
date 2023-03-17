package com.borsch_team.hackathonReligion.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.borsch_team.hackathonReligion.R
import com.borsch_team.hackathonReligion.data.models.FilmModel
import com.borsch_team.hackathonReligion.databinding.ImageHorizontalRowBinding
import com.borsch_team.hackathonReligion.databinding.ItemFilmBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GalleryAdapter(private val clickedItem: (url: String) -> Unit):
    RecyclerView.Adapter<GalleryAdapter.ViewHolder?>() {

    private var dataList = emptyList<String>()

    @SuppressLint("NotifyDataSetChanged")
    internal fun setDataList(dataList: ArrayList<String>){
        this.dataList = dataList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ImageHorizontalRowBinding,
                     private val clickedItem: (url: String) -> Unit):
        RecyclerView.ViewHolder(binding.root){
        fun bind(url: String){
            Glide.with(binding.root)
                .load(url)
                .centerCrop()
                .apply(RequestOptions().override(900, 600))
                .placeholder(R.color.placeholder_color)
                .into(binding.image)
            binding.root.setOnClickListener {
                clickedItem(url)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ImageHorizontalRowBinding
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
