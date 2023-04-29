package com.borsch_team.adminReligion.ui.churches.church_detail

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.data.api.API
import com.borsch_team.hackathonReligion.data.models.Church
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChurchDetailViewModel: ViewModel() {

    var mutableLiveDataPhotos = MutableLiveData<ArrayList<String>>()

    fun removePhoto(url: String, churchId: String){
        viewModelScope.launch{
            API.removePhoto(url, churchId)
        }
    }

    fun addPhotos(photoUris: List<Uri>, churchId: String){
        viewModelScope.launch{
            val photos = API.uploadPhotos(photoUris, churchId)
            mutableLiveDataPhotos.postValue(photos)
        }
    }

    fun updateData(church: Church){
        viewModelScope.launch{
            API.updateChurch(church)
        }
    }

}