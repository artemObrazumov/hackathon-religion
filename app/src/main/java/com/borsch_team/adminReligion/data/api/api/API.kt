package com.borsch_team.hackathonReligion.data.api

import android.net.Uri
import android.util.Log
import com.borsch_team.hackathonReligion.data.models.Church
import com.borsch_team.hackathonReligion.data.models.FeedbackModel
import com.borsch_team.adminReligion.data.api.models.Parishes
import com.borsch_team.hackathonReligion.data.models.Request
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import java.util.*
import kotlin.collections.ArrayList

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

        suspend fun loadChurchesOfParish(): ArrayList<Church> {
            val db = FirebaseFirestore.getInstance()
            val parishesRef = db.collection("Churches")
            val parishesList = ArrayList<Church>()
            try {
                val querySnapshot = parishesRef.get().await()
                for (document in querySnapshot.documents) {
                    val parish = document.toObject(Church::class.java)
                    if (parish != null) {
                        parishesList.add(parish)
                    }
                }
                // использование списка объектов класса MyItem
            } catch (exception: Exception) {
                Log.e("Error Database", "Error getting documents: ", exception)
            }
            return parishesList
        }

        suspend fun removePhoto(url: String, churchId: String){
            // Удаляем с Firebase Storage
            val storageRef = FirebaseStorage.getInstance().getReferenceFromUrl(url)
            storageRef.delete()
            // Удаляем ссылку на фото с Firebase Firestore
            // Получаем текущий список с ссылками
            val db = FirebaseFirestore.getInstance()
            val docRef = db.collection("Churches").document(churchId)
            val arrPhotos = docRef.get().await().get("urlsImages") as ArrayList<*>
            // Удаляем из этого массива ссылку и загружаем новый массив
            arrPhotos.remove(url)
            docRef.update("urlsImages", arrPhotos).await()
        }

        suspend fun uploadPhotos(photoUris: List<Uri>, churchId: String): ArrayList<String> {

            // Добавляем фотки в FirebaseStorage
            val storage = FirebaseStorage.getInstance()
            val urls = ArrayList<String>()
            photoUris.forEach { uri ->
                val ref = storage.reference.child("photo_churches/${UUID.randomUUID()}")
                val task = ref.putFile(uri).await()
                val url = ref.downloadUrl.await().toString()
                urls.add(url)
            }
            // Добавляем ссылки в FirebaseFirestore
            val db = FirebaseFirestore.getInstance()
            val docRef = db.collection("Churches").document(churchId)
            val arrPhotos = docRef.get().await().get("urlsImages") as ArrayList<String>

            urls.forEach {
                arrPhotos.add(it)
            }

            docRef.update("urlsImages", arrPhotos).await()

            return arrPhotos
        }

        suspend fun updateChurch(church : Church){
            val firestore = FirebaseFirestore.getInstance()
            val docRef = firestore.collection("Churches").document(church.id)
            docRef.set(church).await()
        }

        suspend fun loadParishes(): List<Parishes> =
            FirebaseFirestore.getInstance().collection("Parishes")
                .get().await()
                .toObjects(Parishes::class.java)

        suspend fun loadParish(id: String): Parishes =
            FirebaseFirestore.getInstance().collection("Parishes").document(id)
                .get().await().toObject(Parishes::class.java)!!

        suspend fun loadChurches(): List<Church> =
            FirebaseFirestore.getInstance().collection("Churches")
                .get().await().toObjects(Church::class.java)

        suspend fun loadChurchesOfParishes(churchesId: java.util.ArrayList<String>): List<Church> {
            val churches = mutableListOf<Church>()
            churchesId.forEach {
                churches.add(
                    FirebaseFirestore.getInstance().collection("Churches").document(it)
                        .get().await().toObject(Church::class.java)!!
                )
            }
            return churches
        }

        suspend fun uploadParishImage(imageURI: Uri): String {
            val reference = FirebaseStorage.getInstance()
                .getReference("parishThumbnails/${UUID.randomUUID()}")
            reference.putFile(imageURI).await()
            return reference.downloadUrl.await().toString()
        }

        suspend fun uploadParish(parish: Parishes, onFinished: () -> Unit) {
            FirebaseFirestore.getInstance().collection("Parishes")
                .document(parish.id).set(parish).await()
            onFinished()
        }
    }
}