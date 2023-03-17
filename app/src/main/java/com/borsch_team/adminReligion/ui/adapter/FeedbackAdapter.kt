package com.borsch_team.adminReligion.ui.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.borsch_team.adminReligion.databinding.FeedbackItemBinding
import com.borsch_team.adminReligion.databinding.RequestItemBinding
import com.borsch_team.hackathonReligion.data.models.FeedbackModel
import com.borsch_team.hackathonReligion.data.models.Request


class FeedbackAdapter(
    private var dataSet: List<FeedbackModel>
): RecyclerView.Adapter<FeedbackAdapter.ViewHolder>() {

    class ViewHolder(private val binding: FeedbackItemBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(
                request: FeedbackModel
            ) {
                binding.requestContent.text = "Имя: ${request.name}\n${request.feedbackText}"
                binding.requestEmail.text = request.email
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(FeedbackItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataset(newDataset: List<FeedbackModel>) {
        dataSet = newDataset
        notifyDataSetChanged()
    }
}