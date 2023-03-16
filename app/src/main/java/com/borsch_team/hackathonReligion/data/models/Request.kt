package com.borsch_team.hackathonReligion.data.models

import android.provider.ContactsContract.CommonDataKinds.Organization

data class Request (
    var id: String = "",
    var fullName: String = "",
    var organization: String = "",
    var email: String = "",
    var phone: String = "",
    var people: Int = 0,
    var commentary: String = "",
)