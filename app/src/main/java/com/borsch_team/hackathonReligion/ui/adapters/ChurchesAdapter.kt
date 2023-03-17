package com.borsch_team.hackathonReligion.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.borsch_team.hackathonReligion.data.models.Church
import com.borsch_team.hackathonReligion.databinding.ChurchItemBinding
import com.bumptech.glide.Glide

class ChurchesAdapter(
    private val onClicked: (id: String) -> Unit,
): RecyclerView.Adapter<ChurchesAdapter.ViewHolder>() {

    private var dataSet: List<Church> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    internal fun setDataList(dataSet: List<Church>){
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ChurchItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            church: Church,
            onClicked: (id: String) -> Unit
        ) {
            binding.title.text = church.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ChurchItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position]) {onClicked(it)}
    }

    override fun getItemCount(): Int = dataSet.size

}