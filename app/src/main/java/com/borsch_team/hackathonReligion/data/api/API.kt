package com.borsch_team.hackathonReligion.data.api


import com.borsch_team.hackathonReligion.data.api.mail.TestMailSender
import com.borsch_team.hackathonReligion.data.models.*
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.util.*
import kotlin.collections.ArrayList

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

        suspend fun sendEmail(message: String, subject: String){
            TestMailSender.sendEmail(message, subject)
        }

        suspend fun loadParishes(): List<Parishes> {
            val result = ArrayList<Parishes>()
            val firestoreResult = FirebaseFirestore.getInstance().collection("Parishes")
                .get().await()
            val parishes: List<Parishes> = firestoreResult.toObjects(Parishes::class.java)
            result.addAll(parishes)
            return result
        }

        suspend fun getAllPoints(): ArrayList<Church> {
            val result = FirebaseFirestore.getInstance().collection("Churches").get().await()
            val results: ArrayList<Church> = ArrayList()
            result.forEach {
                results.add(it.toObject(Church::class.java))
            }
            return results
        }

    }
}