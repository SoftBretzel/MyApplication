package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_centrale_marseille.*

class CentraleMarseille : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_centrale_marseille)

        button.setOnClickListener {
            val monIntent = Intent(this, threeButtons::class.java)
            startActivity(monIntent)
        }


    }
}