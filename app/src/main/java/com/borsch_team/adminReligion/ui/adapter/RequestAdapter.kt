package com.borsch_team.adminReligion.ui.adapter

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.borsch_team.adminReligion.R
import com.borsch_team.adminReligion.databinding.RequestItemBinding

class RequestAdapter: RecyclerView.Adapter<RequestAdapter.ViewHolder> {

    class ViewHolder(binding: RequestItemBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind()
    }
}