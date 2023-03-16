package com.borsch_team.hackathonReligion.ui.church_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChurchInfoViewModel : ViewModel() {
    private val _churchInfo = MutableLiveData<String>()
    val churchInfo: LiveData<String> = _churchInfo
}