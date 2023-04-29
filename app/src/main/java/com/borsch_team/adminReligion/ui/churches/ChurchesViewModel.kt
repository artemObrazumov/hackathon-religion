package com.borsch_team.adminReligion.ui.churches

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.data.api.API
import com.borsch_team.hackathonReligion.data.models.Church
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChurchesViewModel: ViewModel() {

    val churches: MutableLiveData<List<Church>> = MutableLiveData()

    fun loadChurchesOfParish() {
        viewModelScope.launch(Dispatchers.IO) {
            churches.postValue(API.loadChurchesOfParish())
        }
    }
}