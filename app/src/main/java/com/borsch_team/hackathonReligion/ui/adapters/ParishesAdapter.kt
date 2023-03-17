package com.borsch_team.hackathonReligion.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.borsch_team.hackathonReligion.data.models.Parishes
import com.borsch_team.hackathonReligion.databinding.ParishesItemBinding
import com.bumptech.glide.Glide

class ParishesAdapter(
    private val onClicked: (id: String) -> Unit,
): RecyclerView.Adapter<ParishesAdapter.ViewHolder>() {

    private var dataSet: List<Parishes> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    internal fun setDataList(dataSet: List<Parishes>){
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ParishesItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            parish: Parishes,
            onClicked: (id: String) -> Unit
        ) {
            binding.title.text = parish.title
            Glide
                .with(binding.root)
                .load(parish.thumbnail)
                .into(binding.shapeableImageView)
            binding.root.setOnClickListener { onClicked(parish.id) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ParishesItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position]) {onClicked(it)}
    }

    override fun getItemCount(): Int = dataSet.size

}