package com.borsch_team.adminReligion.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.borsch_team.adminReligion.databinding.ChurchItemBinding
import com.borsch_team.hackathonReligion.data.models.Church


class ChurchesAdapter(
    private val onClicked: (church: Church) -> Unit,
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
            onClicked: (church: Church) -> Unit
        ) {
            binding.title.text = church.name
            binding.root.setOnClickListener {
                onClicked(church)
            }
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
