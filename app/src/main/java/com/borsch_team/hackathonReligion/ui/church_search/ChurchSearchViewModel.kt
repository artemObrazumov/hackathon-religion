package com.borsch_team.hackathonReligion.ui.church_search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.data.api.API
import com.borsch_team.hackathonReligion.data.models.Church
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChurchSearchViewModel: ViewModel() {
    val oldMarkers: MutableLiveData<List<Church>> = MutableLiveData()
    val newMarkers: MutableLiveData<List<Church>> = MutableLiveData()

    fun loadMarkers() {
        viewModelScope.launch(Dispatchers.IO) {
            val markers = API.getAllPoints()
            val old = ArrayList<Church>()
            val new = ArrayList<Church>()
            markers.forEach {
                if (it.isOld) {
                    old.add(it)
                } else {
                    new.add(it)
                }
            }
            oldMarkers.postValue(old)
            newMarkers.postValue(new)
        }
    }
}