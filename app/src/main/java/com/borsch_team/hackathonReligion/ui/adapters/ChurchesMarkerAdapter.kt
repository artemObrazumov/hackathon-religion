package com.borsch_team.hackathonReligion.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.borsch_team.hackathonReligion.R
import com.borsch_team.hackathonReligion.data.models.Church
import com.borsch_team.hackathonReligion.databinding.ChurchItemMarkerBinding

class ChurchesMarkerAdapter(
    private val onClicked: (church: Church) -> Unit,
): RecyclerView.Adapter<ChurchesMarkerAdapter.ViewHolder>() {

    private var dataSet: List<Church> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    internal fun setDataList(dataSet: List<Church>){
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ChurchItemMarkerBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            church: Church,
            onClicked: (church: Church) -> Unit
        ) {
            binding.title.text = church.name
            if (!church.isOld) {
                binding.churchIcon.setColorFilter(
                    ContextCompat.getColor(
                        binding.churchIcon.context, R.color.newChurch), android.graphics.PorterDuff.Mode.SRC_IN)
                binding.churchIcon.setBackgroundResource(R.drawable.church_new_item_background)
            }
            binding.root.setOnClickListener {
                onClicked(church)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ChurchItemMarkerBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position]) {onClicked(it)}
    }

    override fun getItemCount(): Int = dataSet.size

}