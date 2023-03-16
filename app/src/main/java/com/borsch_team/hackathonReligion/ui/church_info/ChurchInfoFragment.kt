package com.borsch_team.hackathonReligion.ui.church_info

import android.content.DialogInterface
import android.content.DialogInterface.OnShowListener
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.borsch_team.hackathonReligion.databinding.FragmentChurchInfoBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ChurchInfoFragment(
    private val churchID: String
) : BottomSheetDialogFragment() {

    private var _binding: FragmentChurchInfoBinding? = null
    private val binding get() = _binding!!
    private var _viewModel: ChurchInfoViewModel? = null
    private val viewModel get() = _viewModel!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewModel =
            ViewModelProvider(this).get(ChurchInfoViewModel::class.java)
        _binding = FragmentChurchInfoBinding.inflate(inflater, container, false)
        customizeDialogState()
        return binding.root
    }

    private fun customizeDialogState() {
        dialog?.setOnShowListener(object: OnShowListener {
            override fun onShow(dialog: DialogInterface) {
                binding.root.minimumHeight = Resources.getSystem().getDisplayMetrics().heightPixels
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}