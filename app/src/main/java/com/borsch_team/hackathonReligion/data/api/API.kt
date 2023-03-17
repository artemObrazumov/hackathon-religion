package com.borsch_team.hackathonReligion.data.api


import com.borsch_team.hackathonReligion.data.api.mail.TestMailSender
import com.borsch_team.hackathonReligion.data.models.Church
import com.borsch_team.hackathonReligion.data.models.FeedbackModel
import com.borsch_team.hackathonReligion.data.models.FilmModel
import com.borsch_team.hackathonReligion.data.models.Request
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.util.*

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
        fun sendFeedback(name: String, email: String, feedbackText: String){
            val uuid = UUID.randomUUID().toString()
            FirebaseFirestore.getInstance().collection("Feedbacks").document(uuid).set(
                FeedbackModel(uuid, name, email, feedbackText)
            )
        }

        suspend fun uploadRequest(request: Request) {
            val uuid = UUID.randomUUID().toString()
            request.id = uuid
            FirebaseFirestore.getInstance().collection("Requests").document(uuid)
                .set(request)
        }

        suspend fun getChurchInfo(id: String): Church? {
            val data = FirebaseFirestore.getInstance().collection("Churches").document(id).get().await()
            return data.toObject(Church::class.java)
        }

        suspend fun sendEmail(message: String){
            TestMailSender.sendEmail(message)
        }

    }
}