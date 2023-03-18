package com.borsch_team.hackathonReligion.ui.about_city

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.borsch_team.hackathonReligion.R
import com.borsch_team.hackathonReligion.databinding.FragmentAboutCityBinding

class AboutCityFragment : Fragment() {

    private lateinit var binding: FragmentAboutCityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutCityBinding.inflate(layoutInflater)

        return binding.root
    }

}