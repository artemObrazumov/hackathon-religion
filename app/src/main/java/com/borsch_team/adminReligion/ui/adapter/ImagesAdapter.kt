package com.borsch_team.adminReligion.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.borsch_team.adminReligion.databinding.PhotoItemBinding
import com.bumptech.glide.Glide

class ImagesAdapter(private val deleted: (img: String) -> Unit) : RecyclerView.Adapter<ImagesAdapter.MyViewHolder>() {

    private var dataSet: ArrayList<String> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    internal fun setDataList(dataSet: ArrayList<String>){
        this.dataSet = dataSet
        notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    internal fun removeItem(item: String){
        dataSet.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PhotoItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    inner class MyViewHolder(private val binding: PhotoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            Glide.with(binding.root.context)
                .load(item)
                .into(binding.img)
            binding.btnRemove.setOnClickListener { deleted(item) }
        }
    }
}