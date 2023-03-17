package com.borsch_team.hackathonReligion.ui.parish_detail.parish_churches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.borsch_team.hackathonReligion.databinding.FragmentParishChurchesBinding
import com.borsch_team.hackathonReligion.databinding.FragmentParishDetailBinding
import com.borsch_team.hackathonReligion.databinding.FragmentParishInfoBinding
import com.borsch_team.hackathonReligion.ui.adapters.ChurchesAdapter
import com.borsch_team.hackathonReligion.ui.parish_detail.parish_info.ParishInfoViewModel

class ParishChurchesFragment(
    private val parishID: String
): Fragment() {

    private lateinit var binding: FragmentParishChurchesBinding
    private lateinit var viewModel: ParishChurchesViewModel
    private lateinit var adapter: ChurchesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentParishChurchesBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[ParishChurchesViewModel::class.java]
        adapter = ChurchesAdapter {  }
        viewModel.loadChurchesOfParish(parishID)
        viewModel.churches.observe(viewLifecycleOwner) { churches ->
            adapter.setDataList(churches)
        }
        binding.churches.layoutManager = LinearLayoutManager(requireContext())
        binding.churches.adapter = adapter
        return binding.root
    }
}