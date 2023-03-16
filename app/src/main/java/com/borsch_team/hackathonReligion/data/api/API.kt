package com.borsch_team.hackathonReligion.data.api

import com.borsch_team.hackathonReligion.data.models.FilmModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class API {
    companion object{
        suspend fun getFilmList(): ArrayList<FilmModel> {
            val snap = FirebaseFirestore.getInstance().collection("Videos").get().await()
            val arr: ArrayList<FilmModel> = ArrayList()

            for (obj in snap){
                val model = obj.toObject(FilmModel::class.java)
                arr.add(model)
            }

            return arr
        }

        suspend fun getDataListItemsNewChurches(){

        }
    }
}