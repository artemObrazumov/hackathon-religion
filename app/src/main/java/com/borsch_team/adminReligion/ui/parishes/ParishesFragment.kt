package com.borsch_team.adminReligion.ui.parishes

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.borsch_team.adminReligion.databinding.FragmentParishesBinding
import com.borsch_team.adminReligion.ui.adapter.ParishesAdapter
import com.borsch_team.adminReligion.ui.parish_editor.ParishEditorActivity
import com.google.firebase.firestore.FirebaseFirestore

class ParishesFragment : Fragment(){

    private lateinit var binding: FragmentParishesBinding
    private lateinit var viewModel: ParishesViewModel
    private lateinit var adapter: ParishesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentParishesBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[ParishesViewModel::class.java]
        viewModel.loadParishes()
        adapter = ParishesAdapter(emptyList(), { id ->
            startActivity(Intent(requireContext(), ParishEditorActivity::class.java).apply {
                putExtra("parishId", id)
            })
        }) { id ->
            FirebaseFirestore.getInstance().collection("Parishes").document(id).delete()
            adapter.removeItemById(id)
        }
        binding.addParish.setOnClickListener {
            startActivity(Intent(requireContext(), ParishEditorActivity::class.java))
        }
        viewModel.parishes.observe(viewLifecycleOwner) { parishes ->
            adapter.setDataList(parishes)
        }
        binding.parishes.layoutManager = LinearLayoutManager(requireContext())
        binding.parishes.adapter = adapter
        return binding.root
    }
}