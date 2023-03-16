package com.borsch_team.hackathonReligion

import android.app.Application
import com.yandex.mapkit.MapKitFactory

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey("02a6765a-370c-442e-989a-a3fe5a25bfb7")
    }
}