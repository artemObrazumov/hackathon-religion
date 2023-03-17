package com.borsch_team.hackathonReligion.ui.image_viewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.borsch_team.hackathonReligion.databinding.ActivityImageViewerBinding
import com.bumptech.glide.Glide

class ImageViewerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageViewerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        binding = ActivityImageViewerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("urlPhoto")

        Glide
            .with(this)
            .load(url)
            .into(binding.photoView)

    }

}