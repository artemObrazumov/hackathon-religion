package com.borsch_team.hackathonReligion.ui.church_search

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.borsch_team.hackathonReligion.databinding.FragmentChurchSearchBinding
import com.borsch_team.hackathonReligion.ui.churches.ChurchesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ChurchSearchFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentChurchSearchBinding
    private lateinit var viewModel: ChurchSearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChurchSearchBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[ChurchSearchViewModel::class.java]
        customizeDialogState()



        binding.search.setOnClickListener {
            // searching
        }

        return binding.root
    }

    private fun customizeDialogState() {
        dialog?.setOnShowListener {
            binding.root.minimumHeight = Resources.getSystem().displayMetrics.heightPixels
        }
    }
}