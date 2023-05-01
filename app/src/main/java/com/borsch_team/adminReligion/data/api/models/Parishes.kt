package com.borsch_team.adminReligion.data.api.models

data class Parishes(
    var id: String = "",
    var title: String = "",
    var thumbnail: String = "",
    var mainInfo: String = "",
    var closingInfo: String = "",
    var restoringInfo: String = "",
    var churches: ArrayList<String> = arrayListOf(),
)