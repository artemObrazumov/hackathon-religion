package com.borsch_team.hackathonReligion.ui.feedback

import androidx.lifecycle.ViewModel
import com.borsch_team.hackathonReligion.data.api.API

class FeedbackViewModel: ViewModel() {
    fun sendFeedback(name: String, email: String, feedbackText: String){
        API.sendFeedback(name, email, feedbackText)
    }
}