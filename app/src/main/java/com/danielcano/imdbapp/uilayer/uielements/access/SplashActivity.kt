package com.danielcano.imdbapp.uilayer.uielements.access

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.danielcano.imdbapp.R
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val accessIntent = Intent(this, UserAccessActivity::class.java)
        Timer().schedule(timerTask { startActivity(accessIntent) }, 3000)
    }
}