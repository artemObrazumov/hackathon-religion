package com.borsch_team.hackathonReligion.ui.sign_up_tour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.borsch_team.hackathonReligion.data.models.Request
import com.borsch_team.hackathonReligion.databinding.FragmentExcursionsBinding
import com.borsch_team.hackathonReligion.databinding.FragmentSignUpTourBinding
import com.borsch_team.hackathonReligion.ui.excursions.ExcursionsViewModel
import com.borsch_team.hackathonReligion.ui.thanks.ThanksFragment

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
        binding.send.setOnClickListener {
            viewModel.uploadRequest(
                createRequestModel()
            )
            clearForm()
            ThanksFragment().show(childFragmentManager, "")
        }
        return binding.root
    }

    private fun clearForm() {
        binding.inputSurname.text.clear()
        binding.inputName.text.clear()
        binding.inputParent.text.clear()
        binding.inputOrganization.text.clear()
        binding.inputEmail.text.clear()
        binding.inputPhone.text.clear()
        binding.inputPeople.text.clear()
        binding.inputCommentary.text.clear()
    }

    private fun createRequestModel(): Request = Request(
        "",
        "${binding.inputSurname.text} ${binding.inputName.text} ${binding.inputParent.text}",
         binding.inputOrganization.text.toString(),
        binding.inputEmail.text.toString(),
        binding.inputPhone.text.toString(),
        binding.inputPeople.text.toString().toInt(),
        binding.inputCommentary.text.toString()
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}