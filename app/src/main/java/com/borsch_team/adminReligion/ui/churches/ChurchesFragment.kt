package com.borsch_team.adminReligion.ui.churches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.borsch_team.adminReligion.R
import com.borsch_team.adminReligion.databinding.FragmentChurchesBinding
import com.borsch_team.adminReligion.ui.adapter.ChurchesAdapter

class ChurchesFragment: Fragment() {

    private lateinit var binding: FragmentChurchesBinding
    private lateinit var viewModel: ChurchesViewModel
    private lateinit var adapter: ChurchesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChurchesBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[ChurchesViewModel::class.java]

        adapter = ChurchesAdapter {
            Navigation.findNavController(binding.root).navigate(R.id.nav_church_detail,
                bundleOf(
                    "church_id" to it.id,
                    "church_name" to it.name,
                    "church_desc" to it.description,
                    "church_x" to it.x,
                    "church_y" to it.y,
                    "church_images" to it.urlsImages,
                    "church_is_old" to it.isOld,
                ))
        }

        viewModel.loadChurchesOfParish()
        viewModel.churches.observe(viewLifecycleOwner) { churches ->
            adapter.setDataList(churches)
        }
        binding.recyclerChurches.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerChurches.adapter = adapter

        return binding.root
    }
}