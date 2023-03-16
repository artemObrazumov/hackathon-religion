package com.borsch_team.hackathonReligion.ui.films

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.data.api.API
import com.borsch_team.hackathonReligion.data.models.FilmModel
import kotlinx.coroutines.launch

class FilmsViewModel : ViewModel() {
    val liveDataListItemsEducation: MutableLiveData<ArrayList<FilmModel>> = MutableLiveData()

    init {
        getDataListFromDatabase()
    }

    private fun getDataListFromDatabase(){
        viewModelScope.launch {
            liveDataListItemsEducation.postValue(API.getFilmList())
        }
    }
}