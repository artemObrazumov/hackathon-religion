package com.borsch_team.hackathonReligion.data.api

import com.borsch_team.hackathonReligion.data.models.FilmModel

class API {
    companion object{
        fun getFilmList(): ArrayList<FilmModel> {
            return arrayListOf(
                FilmModel("Film1", "≈ 3 мин", "https://firebasestorage.googleapis.com/v0/b/time-mashine-minsk.appspot.com/o/lesson1%20(1).mp4?alt=media&token=61510d1b-bf24-40c7-bbd8-164f48dc7770", "https://protabletpc.ru/wp-content/uploads/2021/06/1529216706_1-111-2048x1152.jpg")
            )
        }
    }
}