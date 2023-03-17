package com.borsch_team.adminReligion.ui.request.requestDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.data.api.API
import com.borsch_team.hackathonReligion.data.models.Request
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RequestViewModel : ViewModel() {

    val requests = MutableLiveData<List<Request>>()

    fun loadRequests(archived: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            requests.postValue(API.getRequestsList(archived))
        }
    }

    fun archiveRequest(requestID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            API.archiveRequest(requestID)
        }
    }
}