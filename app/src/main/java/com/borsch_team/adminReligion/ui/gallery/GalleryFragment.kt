package com.borsch_team.adminReligion.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.borsch_team.adminReligion.databinding.FragmentGalleryBinding
import com.borsch_team.adminReligion.ui.adapter.FeedbackAdapter

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private var _viewModel: GalleryViewModel? = null
    private val viewModel get() = _viewModel!!
    private lateinit var adapter: FeedbackAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        adapter = FeedbackAdapter(emptyList())
        binding.feedback.layoutManager = LinearLayoutManager(requireContext())
        binding.feedback.adapter = adapter
        viewModel.feedback.observe(viewLifecycleOwner) { feedback ->
            adapter.updateDataset(feedback)
        }
        viewModel.loadFeedback()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}