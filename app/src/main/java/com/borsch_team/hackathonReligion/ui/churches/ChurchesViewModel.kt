package com.borsch_team.hackathonReligion.ui.churches


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.data.api.API
import com.borsch_team.hackathonReligion.data.models.Church
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class ChurchesViewModel : ViewModel() {
    val liveDataListItemsPoints: MutableLiveData<ArrayList<Church>> = MutableLiveData()

    fun getDataListPoints(){
        viewModelScope.launch(Dispatchers.IO) {
            liveDataListItemsPoints.postValue(API.getAllPoints())
        }
    }
}