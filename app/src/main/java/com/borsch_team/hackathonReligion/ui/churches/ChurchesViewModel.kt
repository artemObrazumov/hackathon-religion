package com.borsch_team.hackathonReligion.ui.churches


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.borsch_team.hackathonReligion.data.models.Church
import java.util.*
import kotlin.collections.ArrayList

class ChurchesViewModel : ViewModel() {
    val liveDataListItemsNewChurches: MutableLiveData<ArrayList<Church>> = MutableLiveData()
    val liveDataListItemsOldChurches: MutableLiveData<ArrayList<Church>> = MutableLiveData()

    init{
        getDataListItemsNewChurches()
        getDataListItemsOldChurches()
    }

    private fun getDataListItemsNewChurches(){

    }

    private fun getDataListItemsOldChurches(){
        liveDataListItemsOldChurches.postValue(arrayListOf(
            Church(UUID.randomUUID().toString(), 0.00, 0.00, true, "Name1", "desc", arrayListOf("url1", "url2"))
        ))
    }
}