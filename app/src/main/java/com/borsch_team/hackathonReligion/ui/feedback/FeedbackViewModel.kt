package com.borsch_team.hackathonReligion.ui.feedback

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.data.api.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedbackViewModel: ViewModel() {
    fun sendFeedback(name: String, email: String, feedbackText: String){
        viewModelScope.launch(Dispatchers.IO) {
            API.sendFeedback(name, email, feedbackText)
            API.sendEmail("Имя: $name\nЭлектронная почта:$email\nОтзыв:$feedbackText", "Отзыв о Приложении: Приложение Православный Арзамас")
        }
    }
}