package com.borsch_team.adminReligion.ui.request

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.borsch_team.adminReligion.ui.request.requestDetail.RequestDetailFragment

class RequestTabAdapter (
    activity: FragmentActivity
) : FragmentStateAdapter(activity) {
    private val newFragment = RequestDetailFragment(false) {
        archiveFragment.addRequest(it)
    }
    private val archiveFragment = RequestDetailFragment(true) {}
    override fun createFragment(position: Int): Fragment =
        if (position == 0) {
            newFragment
        } else {
            archiveFragment
        }

    override fun getItemCount(): Int = 2
}