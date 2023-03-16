package com.borsch_team.hackathonReligion.ui.feedback

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.borsch_team.hackathonReligion.databinding.FragmentFeedbackBinding

class FeedbackFragment: Fragment() {
    private lateinit var binding: FragmentFeedbackBinding
    private lateinit var viewModel: FeedbackViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedbackBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[FeedbackViewModel::class.java]

        binding.feedbackBtnSubmit.setOnClickListener {
            val name: String  = binding.feedbackEtName.text.toString()
            val email: String  = binding.feedbackEtEmail.text.toString()
            val feedbackText: String  = binding.feedbackEtFeedback.text.toString()

            if(name != "" && email != "" && feedbackText != ""){
                viewModel.sendFeedback(name, email, feedbackText)
                Toast.makeText(context, "Отзыв отправлен", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Заполните все поля!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}