package com.borsch_team.hackathonReligion.ui.parish_detail

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.borsch_team.hackathonReligion.R
import com.borsch_team.hackathonReligion.databinding.FragmentParishDetailBinding
import com.borsch_team.hackathonReligion.ui.main.MainActivity

class ParishDetailFragment: Fragment() {

    private lateinit var binding: FragmentParishDetailBinding
    private lateinit var adapter: ParishDetailTabAdapter
    private lateinit var textColor: ColorStateList

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentParishDetailBinding.inflate(inflater, container, false)
        adapter = ParishDetailTabAdapter(
            requireActivity(), requireArguments().getString("parishID")!!
        ) {
            (activity as MainActivity).supportActionBar!!.title = it.title
        }
        binding.pager.adapter = adapter
        binding.pager.offscreenPageLimit = 2
        binding.buttonTab1.setOnClickListener {
            onTabClicked(0)
        }
        binding.buttonTab2.setOnClickListener {
            onTabClicked(1)
        }
        binding.pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                onTabClicked(position, false)
            }
        })
        textColor = binding.tabText1.textColors
        onTabClicked(0)
        return binding.root
    }

    private fun onTabClicked(position: Int, changeTab: Boolean = true) {
        if (changeTab) binding.pager.setCurrentItem(position, true)
        if (position == 0) {
            binding.buttonTab1.setBackgroundResource(R.drawable.tab_background_selected)
            binding.buttonTab2.setBackgroundResource(R.drawable.tab_background)
            binding.tabText1.setTextColor(
                ContextCompat.getColor(requireContext(), R.color.white)
            )
            binding.tabText2.setTextColor(textColor)
        }
        if (position == 1) {
            binding.buttonTab1.setBackgroundResource(R.drawable.tab_background)
            binding.buttonTab2.setBackgroundResource(R.drawable.tab_background_selected)
            binding.tabText1.setTextColor(textColor)
            binding.tabText2.setTextColor(
                ContextCompat.getColor(requireActivity(), R.color.white)
            )
        }
    }
}