package com.borsch_team.hackathonReligion.ui.excursions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.borsch_team.hackathonReligion.databinding.FragmentExcursionsBinding

class ExcursionsFragment : Fragment() {

    private var _binding: FragmentExcursionsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val excursionsViewModel =
            ViewModelProvider(this).get(ExcursionsViewModel::class.java)

        _binding = FragmentExcursionsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        excursionsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}