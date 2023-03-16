package com.borsch_team.hackathonReligion.ui.sign_up_tour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.borsch_team.hackathonReligion.databinding.FragmentExcursionsBinding
import com.borsch_team.hackathonReligion.databinding.FragmentSignUpTourBinding
import com.borsch_team.hackathonReligion.ui.excursions.ExcursionsViewModel

class SignUpTourFragment : Fragment() {

    private var _binding: FragmentSignUpTourBinding? = null
    private val binding get() = _binding!!
    private var _viewModel: TourViewModel? = null
    private val viewModel get() = _viewModel!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewModel =
            ViewModelProvider(this)[TourViewModel::class.java]

        _binding = FragmentSignUpTourBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}