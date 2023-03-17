package com.borsch_team.adminReligion.ui.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.data.api.API
import com.borsch_team.hackathonReligion.data.models.FeedbackModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GalleryViewModel : ViewModel() {

    val feedback: MutableLiveData<List<FeedbackModel>> = MutableLiveData()

    fun loadFeedback() {
        viewModelScope.launch(Dispatchers.IO) {
            feedback.postValue(API.getFeedback())
        }
    }
}