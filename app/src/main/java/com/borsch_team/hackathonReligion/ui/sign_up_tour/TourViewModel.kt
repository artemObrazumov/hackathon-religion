package com.borsch_team.hackathonReligion.ui.sign_up_tour

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.data.api.API
import com.borsch_team.hackathonReligion.data.models.Request
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TourViewModel : ViewModel() {

    fun uploadRequest(request: Request) {
        viewModelScope.launch(Dispatchers.IO) {
            API.uploadRequest(request)
            API.sendEmail("ФИО: ${request.fullName}\nЭлектронная почта: ${request.email}\nНомер телефона: ${request.phone}\n" +
                    "Организация: ${request.organization}\nКоличество человек: ${request.people}\nКомментарий: ${request.commentary}",
            "Заявка на экскурсию: Приложение Православный Арзамас")
        }
    }
}