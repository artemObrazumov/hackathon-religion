package com.borsch_team.hackathonReligion.ui.excursions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.data.api.API
import com.borsch_team.hackathonReligion.data.models.Parishes
import kotlinx.coroutines.launch

class ExcursionsViewModel : ViewModel() {

    val parishes: MutableLiveData<List<Parishes>> = MutableLiveData()

    fun loadParishes() {
        viewModelScope.launch {
            parishes.postValue(API.loadParishes())
        }
    }
}