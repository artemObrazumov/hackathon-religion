package com.borsch_team.adminReligion.ui.parishes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.data.api.API
import com.borsch_team.adminReligion.data.api.models.Parishes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ParishesViewModel: ViewModel() {
    val parishes: MutableLiveData<List<Parishes>> = MutableLiveData()

    fun loadParishes() {
        viewModelScope.launch(Dispatchers.IO) {
            parishes.postValue(API.loadParishes())
        }
    }
}