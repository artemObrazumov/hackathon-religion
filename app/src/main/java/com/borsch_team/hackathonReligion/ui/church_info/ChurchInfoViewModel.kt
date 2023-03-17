package com.borsch_team.hackathonReligion.ui.church_info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.borsch_team.hackathonReligion.data.api.API
import com.borsch_team.hackathonReligion.data.models.Church

class ChurchInfoViewModel : ViewModel() {

    val mutableLiveDataChurch: MutableLiveData<Church> = MutableLiveData()
    suspend fun getChurchInfo(id: String){
        mutableLiveDataChurch.value =  API.getChurchInfo(id)
    }
}