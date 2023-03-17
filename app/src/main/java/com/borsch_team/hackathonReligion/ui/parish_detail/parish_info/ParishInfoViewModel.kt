package com.borsch_team.hackathonReligion.ui.parish_detail.parish_info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.data.api.API
import com.borsch_team.hackathonReligion.data.models.Parishes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ParishInfoViewModel: ViewModel() {
    val parishInfo: MutableLiveData<Parishes> = MutableLiveData()

    fun loadParishInfo(parish: String) {
        viewModelScope.launch(Dispatchers.IO) {
            API.loadParishInfo(parish)
        }
    }
}