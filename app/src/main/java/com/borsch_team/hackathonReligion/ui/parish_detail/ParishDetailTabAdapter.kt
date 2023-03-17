package com.borsch_team.hackathonReligion.ui.parish_detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.borsch_team.hackathonReligion.data.models.Parishes
import com.borsch_team.hackathonReligion.ui.parish_detail.parish_churches.ParishChurchesFragment
import com.borsch_team.hackathonReligion.ui.parish_detail.parish_info.ParishInfoFragment

class ParishDetailTabAdapter(
    activity: FragmentActivity,
    parishID: String,
    onTitleLoaded: (parish: Parishes) -> Unit
) : FragmentStateAdapter(activity) {
    private val infoFragment = ParishInfoFragment(parishID) {
        onTitleLoaded(it)
    }
    private val churchesFragment = ParishChurchesFragment(parishID)
    override fun createFragment(position: Int): Fragment =
        if (position == 0) {
            infoFragment
        } else {
            churchesFragment
        }

    override fun getItemCount(): Int = 2
}