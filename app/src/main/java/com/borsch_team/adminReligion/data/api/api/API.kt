package com.borsch_team.hackathonReligion.data.api

import com.borsch_team.hackathonReligion.data.models.FeedbackModel
import com.borsch_team.hackathonReligion.data.models.Request
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class API {
    companion object{
        suspend fun getRequestsList(archived: Boolean = false): List<Request> {
            val result = ArrayList<Request>()
            val firestoreResult = FirebaseFirestore.getInstance().collection("Requests")
                .whereEqualTo("archived", archived).get().await()
            val requests: List<Request> = firestoreResult.toObjects(Request::class.java)
            result.addAll(requests)
            return result
        }

        suspend fun getFeedback(): List<FeedbackModel> {
            val result = ArrayList<FeedbackModel>()
            val firestoreResult = FirebaseFirestore.getInstance().collection("Feedbacks")
                .get().await()
            val feedback: List<FeedbackModel> = firestoreResult.toObjects(FeedbackModel::class.java)
            result.addAll(feedback)
            return result
        }

        fun archiveRequest(requestID: String) {
            FirebaseFirestore.getInstance().collection("Requests").document(requestID)
                .update("archived", true)
        }
    }
}