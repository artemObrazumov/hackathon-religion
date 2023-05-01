package com.borsch_team.adminReligion.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.borsch_team.adminReligion.R
import com.borsch_team.adminReligion.databinding.ChurchInnerItemBinding
import com.borsch_team.hackathonReligion.data.models.Church

class ChurchesInnerAdapter(
    private var churches: List<Church>,
    private val onClicked: (church: Church) -> Unit,
    private val onErase: (church: Church) -> Unit,
): RecyclerView.Adapter<ChurchesInnerAdapter.ViewHolder>() {
    var canErase: Boolean = false

    class ViewHolder(private val binding: ChurchInnerItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            church: Church,
            canErase: Boolean,
            onClicked: (church: Church) -> Unit,
            onErase: (church: Church) -> Unit
        ) {
            binding.title.text = church.name
            if (!church.isOld) {
                binding.churchIcon.background = ContextCompat
                    .getDrawable(binding.root.context, R.drawable.church_new_item_background)
                binding.churchIcon.setColorFilter(
                    ContextCompat.getColor(
                        binding.churchIcon.context, R.color.newChurch),
                    android.graphics.PorterDuff.Mode.SRC_IN)
            }
            if (canErase) {
                binding.delete.setOnClickListener {
                    onErase(church)
                }
                binding.root.background = null
            } else {
                binding.root.setOnClickListener {
                    onClicked(church)
                }
                binding.delete.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ChurchInnerItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(churches[position], canErase, {onClicked(it)}, {onErase(it)})
    }

    override fun getItemCount(): Int = churches.size

    fun eraseChurch(it: Church) {
        val index = churches.indexOf(it)
        churches = churches.toMutableList().also {
            it.removeAt(index)
        }.toList()
        notifyItemRemoved(index)
    }

    fun addChurch(church: Church) {
        churches = churches.toMutableList().also {
            it.add(church)
        }.toList()
        notifyItemInserted(churches.size)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDataset(it: List<Church>) {
        this.churches = it
        notifyDataSetChanged()
    }

    fun getChurchesIds(): List<String> {
        val ids = mutableListOf<String>()
        churches.forEach{
            ids.add(it.id)
        }
        return ids
    }
}