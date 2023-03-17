package com.borsch_team.hackathonReligion.ui.parish_detail.parish_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.borsch_team.hackathonReligion.data.models.Parishes
import com.borsch_team.hackathonReligion.databinding.FragmentParishDetailBinding
import com.borsch_team.hackathonReligion.databinding.FragmentParishInfoBinding

class ParishInfoFragment(
    private val parishID: String,
    private val onTitleLoaded: (parish: Parishes) -> Unit
): Fragment() {

    private lateinit var binding: FragmentParishInfoBinding
    private lateinit var viewModel: ParishInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentParishInfoBinding.inflate(inflater, container, false)
        binding.root.visibility = View.GONE
        viewModel = ViewModelProvider(this)[ParishInfoViewModel::class.java]
        viewModel.loadParishInfo(parishID)
        viewModel.parishInfo.observe(viewLifecycleOwner) { parish ->
            if (parish.restoringInfo.isEmpty()) {
                binding.restoringTitle.visibility = View.GONE
                binding.restoringInfo.visibility = View.GONE
            }
            onTitleLoaded(parish)
            binding.main.text = parish.mainInfo
            binding.restoringInfo.text = parish.restoringInfo
            binding.closingInfo.text = parish.closingInfo
            binding.root.visibility = View.VISIBLE
        }
        return binding.root
    }
}