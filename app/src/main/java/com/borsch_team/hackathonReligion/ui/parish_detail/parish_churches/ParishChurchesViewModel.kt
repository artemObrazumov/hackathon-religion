package com.borsch_team.hackathonReligion.ui.parish_detail.parish_churches

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.data.api.API
import com.borsch_team.hackathonReligion.data.models.Church
import com.borsch_team.hackathonReligion.data.models.Parishes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ParishChurchesViewModel: ViewModel() {
    val churches: MutableLiveData<List<Church>> = MutableLiveData()

    fun loadChurchesOfParish(parish: String) {
        viewModelScope.launch(Dispatchers.IO) {
            churches.postValue(API.loadChurchesOfParish(parish))
        }
    }
}