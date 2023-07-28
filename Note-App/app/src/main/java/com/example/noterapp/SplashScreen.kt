package com.example.noterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed(Runnable {

            startActivity(Intent(this, MainActivity::class.java))

        }, 2000)


    }

    override fun onResume() {
        super.onResume()


        Handler(Looper.getMainLooper()).postDelayed(Runnable {

            startActivity(Intent(this, MainActivity::class.java))

        }, 2000)


    }


}