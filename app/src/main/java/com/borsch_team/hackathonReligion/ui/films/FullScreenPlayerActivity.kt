package com.borsch_team.hackathonReligion.ui.films

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.borsch_team.hackathonReligion.databinding.ActivityFullScreenPlayerBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.StyledPlayerView


class FullScreenPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenPlayerBinding
    //player
    private lateinit var player: ExoPlayer
    private lateinit var playerView: StyledPlayerView
    private lateinit var progressBar: ProgressBar

    private var timeStart: Long = 0
    private var fileName: String = ""
    private var urlVideo: String = ""
    private var lastTimePlayer: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenPlayerBinding.inflate(layoutInflater)
        supportActionBar!!.hide()
        progressBar = binding.progressBar

        timeStart = intent.getLongExtra("timeStart", 0)

        fileName = intent.getStringExtra("fileName")!!
        urlVideo = intent.getStringExtra("urlVideo")!!
        lastTimePlayer = intent.getLongExtra("lastTimePlayer", 0)

        setupPlayer()
        addMP4Files(fileName, urlVideo, lastTimePlayer)

        setContentView(binding.root)
    }

    private fun setupPlayer() {
        player = ExoPlayer.Builder(this).build()
        playerView = binding.videoView
        playerView.setFullscreenButtonClickListener {
            player.stop()
            player.release()
            onBackPressed()
        }

        playerView.player = player
        player.addListener(object : Player.Listener{
            override fun onPlaybackStateChanged(state: Int) {
                when (state) {
                    Player.STATE_BUFFERING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                    Player.STATE_READY -> {
                        progressBar.visibility = View.INVISIBLE
                    }
                }
            }
        })
    }

    private fun addMP4Files(fileName: String, urlVideo: String, lastTimePlayer: Long) {
        val mediaItem: MediaItem

        val uriVideo = Uri.parse(urlVideo)
        mediaItem = MediaItem.fromUri(uriVideo)


        if(player.mediaItemCount == 0){
            player.addMediaItem(mediaItem)
        }else{
            player.removeMediaItems(0, player.mediaItemCount)
            player.addMediaItem(mediaItem)
        }

        player.seekTo(lastTimePlayer)
        player.prepare()
        player.playWhenReady = false;
    }

    override fun onStop() {
        super.onStop()
        player.stop()
        player.release()
    }

    override fun onResume() {
        super.onResume()
        setupPlayer()
        addMP4Files(fileName, urlVideo, lastTimePlayer)
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            player.stop()
            player.release()
        }catch (ex: Exception){
            Log.d("ErrorPlayer", ex.stackTraceToString())
        }
        Log.d("player", "onSaveInstanceState: " + player.currentPosition)
    }
}