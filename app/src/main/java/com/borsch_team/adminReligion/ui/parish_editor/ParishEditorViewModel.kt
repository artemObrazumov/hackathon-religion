package com.borsch_team.adminReligion.ui.parish_editor

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.data.api.API
import com.borsch_team.hackathonReligion.data.models.Church
import com.borsch_team.adminReligion.data.api.models.Parishes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ParishEditorViewModel: ViewModel() {
    val parish: MutableLiveData<Parishes> = MutableLiveData()
    val churches: MutableLiveData<List<Church>> = MutableLiveData()
    val preloadedChurches: MutableLiveData<List<Church>> = MutableLiveData()
    fun loadParish(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val parishResult = API.loadParish(id)
            parish.postValue(parishResult)
            preloadedChurches
                .postValue(API.loadChurchesOfParishes(parishResult.churches))
        }
    }
    fun loadChurches() {
        viewModelScope.launch(Dispatchers.IO) {
            churches.postValue(API.loadChurches())
        }
    }

    fun uploadParish(parish: Parishes, imageURI: Uri?, onFinished: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            if (imageURI != null) {
                val imageUrl = API.uploadParishImage(imageURI)
                parish.thumbnail = imageUrl
            }
            API.uploadParish(parish) {onFinished()}
        }
    }
}