package com.borsch_team.adminReligion.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.borsch_team.adminReligion.databinding.ParishItemBinding
import com.borsch_team.adminReligion.data.api.models.Parishes
import com.bumptech.glide.Glide


class ParishesAdapter(
    private var parishes: List<Parishes>,
    private val onClicked: (id: String) -> Unit,
    private val onRemove: (id: String) -> Unit,
): RecyclerView.Adapter<ParishesAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    internal fun setDataList(dataSet: List<Parishes>){
        this.parishes = dataSet
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ParishItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(
            item: Parishes,
            onClicked: (id: String) -> Unit,
            onRemove: (id: String) -> Unit
        ) {
            binding.title.text = item.title
            binding.churches.text = "Церквей: ${item.churches.size}"
            Glide.with(binding.root.context)
                .load(item.thumbnail).into(binding.parishThumbnail)
            binding.root.setOnClickListener {
                onClicked(item.id)
            }
            binding.remove.setOnClickListener {
                onRemove(item.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ParishItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(parishes[position], {onClicked(it)}) {onRemove(it)}
    }

    override fun getItemCount(): Int = parishes.size

    fun removeItemById(id: String) {
        val index = parishes.indexOf(parishes.find { it.id == id })
        parishes = parishes.toMutableList().apply {
            removeAt(index)
        }.toList()
        notifyItemRemoved(index)
    }

}
