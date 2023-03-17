package com.borsch_team.hackathonReligion.ui.excursions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.borsch_team.hackathonReligion.databinding.FragmentExcursionsBinding
import com.borsch_team.hackathonReligion.ui.adapters.ParishesAdapter

class ExcursionsFragment : Fragment() {

    private lateinit var binding: FragmentExcursionsBinding
    private lateinit var viewModel: ExcursionsViewModel
    private lateinit var adapter: ParishesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this)[ExcursionsViewModel::class.java]
        binding = FragmentExcursionsBinding.inflate(inflater, container, false)
        viewModel.loadParishes()
        adapter = ParishesAdapter {
            Navigation.findNavController(binding.root)
        }
        viewModel.parishes.observe(viewLifecycleOwner) {
            adapter.setDataList(it)
        }
        binding.parishes.layoutManager = LinearLayoutManager(requireContext())
        binding.parishes.adapter = adapter
        return binding.root
    }
}