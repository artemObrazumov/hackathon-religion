package com.borsch_team.hackathonReligion.data.api

import com.borsch_team.hackathonReligion.data.models.Church
import com.google.firebase.firestore.FirebaseFirestore
import java.util.UUID

class CreateData {
    companion object {
        fun createData(){
            var id = UUID.randomUUID().toString()
            FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                Church(id, 0.00, 0.00, true, "Name1", "desc", arrayListOf("url1", "url2"))
            )
            id = UUID.randomUUID().toString()
            FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                Church(id, 0.00, 0.00, true, "Name1", "desc", arrayListOf("url1", "url2"))
            )
            id = UUID.randomUUID().toString()
            FirebaseFirestore.getInstance().collection("Churches").document(id).set(
                Church(id, 0.00, 0.00, true, "Name1", "desc", arrayListOf("url1", "url2"))
            )


        }
    }
}