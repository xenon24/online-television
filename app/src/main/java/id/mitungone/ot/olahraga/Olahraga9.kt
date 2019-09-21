package id.mitungone.ot.olahraga

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.MediaController
import id.mitungone.ot.Errors
import id.mitungone.ot.R;
import kotlinx.android.synthetic.main.content_video_player.*

class Olahraga9 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        play.setVideoPath("http://eir4.pikaflik.co.uk:80/live?channelId=186&deviceMac=00:1A:79:BE:2F:F6&uid=1615|User-Agent=Mozilla/5.0")
        play.setMediaController(MediaController(this))
        play.start()
        play.setOnErrorListener(MediaPlayer.OnErrorListener { mp, what, extra ->
            val error = Intent(this@Olahraga9, Errors::class.java)
            startActivity(error)
            finish()
            Log.d("video", "setOnErrorListener")
            true
        })

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = Color.BLACK
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI()
        }
    }

    private fun hideSystemUI() {
        val decorView = window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
}