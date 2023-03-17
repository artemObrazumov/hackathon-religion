package com.borsch_team.hackathonReligion.ui.church_search

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.borsch_team.hackathonReligion.data.models.Church
import com.borsch_team.hackathonReligion.databinding.FragmentChurchSearchBinding
import com.borsch_team.hackathonReligion.ui.adapters.ChurchesMarkerAdapter
import com.borsch_team.hackathonReligion.ui.churches.ChurchesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ChurchSearchFragment(
    private val onClicked: (church: Church) -> Unit
) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentChurchSearchBinding
    private lateinit var viewModel: ChurchSearchViewModel
    private lateinit var oldAdapter: ChurchesMarkerAdapter
    private lateinit var newAdapter: ChurchesMarkerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChurchSearchBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[ChurchSearchViewModel::class.java]
        customizeDialogState()
        oldAdapter = ChurchesMarkerAdapter {
            onClicked(it)
            dismiss()
        }
        newAdapter = ChurchesMarkerAdapter {
            onClicked(it)
            dismiss()
        }
        viewModel.loadMarkers()
        viewModel.oldMarkers.observe(viewLifecycleOwner) { churches ->
            oldAdapter.setDataList(churches)
        }
        viewModel.newMarkers.observe(viewLifecycleOwner) { churches ->
            newAdapter.setDataList(churches)
        }

        binding.old.layoutManager = LinearLayoutManager(requireContext())
        binding.old.adapter = oldAdapter
        binding.newChurches.layoutManager = LinearLayoutManager(requireContext())
        binding.newChurches.adapter = newAdapter
        return binding.root
    }

    private fun customizeDialogState() {
        dialog?.setOnShowListener {
            binding.root.minimumHeight = Resources.getSystem().displayMetrics.heightPixels
        }
    }
}