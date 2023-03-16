package com.borsch_team.hackathonReligion.ui.films

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.borsch_team.hackathonReligion.databinding.FragmentFilmsBinding
import com.borsch_team.hackathonReligion.ui.adapters.FilmsAdapter

class FilmsFragment : Fragment() {

    private lateinit var binding: FragmentFilmsBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FilmsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val filmsViewModel =
            ViewModelProvider(this)[FilmsViewModel::class.java]

        filmsViewModel.liveDataListItemsEducation.observe(viewLifecycleOwner){
            adapter.setDataList(it)
        }


        binding = FragmentFilmsBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        adapter = FilmsAdapter {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter


        return binding.root
    }
}