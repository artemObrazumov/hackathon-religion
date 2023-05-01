package com.borsch_team.adminReligion.ui.church_select

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.borsch_team.adminReligion.databinding.FragmentChurchSelectSheetBinding
import com.borsch_team.adminReligion.ui.adapter.ChurchesInnerAdapter
import com.borsch_team.hackathonReligion.data.models.Church
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ChurchSelectSheetFragment(
    private var churches: List<Church>,
    private val onChurchSelected: (church: Church) -> Unit
): BottomSheetDialogFragment() {

    private lateinit var binding: FragmentChurchSelectSheetBinding
    private lateinit var adapter: ChurchesInnerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChurchSelectSheetBinding.inflate(layoutInflater)
        adapter = ChurchesInnerAdapter(churches, {
            onChurchSelected(it)
            dismiss()
        }, {})
        adapter.canErase = false
        binding.churches.layoutManager = LinearLayoutManager(requireContext())
        binding.churches.adapter = adapter
        return binding.root
    }

}