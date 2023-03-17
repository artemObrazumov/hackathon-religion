package com.borsch_team.adminReligion.ui.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.borsch_team.adminReligion.databinding.RequestItemBinding
import com.borsch_team.hackathonReligion.data.models.Request


class RequestAdapter(
    private var dataSet: List<Request>,
    private val archived: Boolean = false,
    private val onEmailClicked: (email: String) -> Unit,
    private val onPhoneClicked: (phone: String) -> Unit,
    private val onArchived: (request: Request) -> Unit,
): RecyclerView.Adapter<RequestAdapter.ViewHolder>() {

    class ViewHolder(private val binding: RequestItemBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(
                request: Request,
                archived: Boolean,
                onEmailClicked: (email: String) -> Unit,
                onPhoneClicked: (phone: String) -> Unit,
                onArchived: (request: Request) -> Unit,
            ) {
                if (archived) {
                    binding.phone.visibility = View.GONE
                    binding.email.visibility = View.GONE
                    binding.archives.visibility = View.GONE
                }
                binding.requestContent.text = generateRequestContent(request)
                binding.requestEmail.text = request.email
                binding.email.setOnClickListener {
                    onEmailClicked(request.email)
                }
                binding.phone.setOnClickListener {
                    onPhoneClicked(request.phone)
                }
                binding.archives.setOnClickListener {
                    onArchived(request)
                }
            }
            private fun generateRequestContent(request: Request): String {
                var content = ""
                content += "Полное имя: ${request.fullName}\n"
                content += "Организация: ${request.organization}\n"
                content += "Телефон: ${request.phone}\n"
                content += "Количество человек: ${request.people}\n"
                content += "Комментарий: ${request.commentary}"
                return content
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RequestItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position], archived, {onEmailClicked(it)}, {onPhoneClicked(it)}, {onArchived(it)})
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataset(newDataset: List<Request>) {
        dataSet = newDataset
        notifyDataSetChanged()
    }

    fun prependRequest(request: Request) {
        dataSet = dataSet.toMutableList().apply {
            add(0, request)
        }.toList()
        notifyItemInserted(0)
    }

    fun removeItem(archiveRequest: Request) {
        val position = dataSet.indexOf(archiveRequest)
        dataSet = dataSet.toMutableList().apply {
            removeAt(position)
        }.toList()
        notifyItemRemoved(position)
    }
}