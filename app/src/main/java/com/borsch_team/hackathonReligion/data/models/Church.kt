package com.borsch_team.hackathonReligion.data.models

data class Church (
    var id: String = "",
    var x: Double = 0.0,
    var y: Double = 0.0,
    var isOld: Boolean = true,
    var name: String = "",
    var description: String = "",
    var urlsImages: ArrayList<String> = ArrayList(),
)