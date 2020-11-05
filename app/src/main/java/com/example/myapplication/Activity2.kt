package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_2.*

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        button2.setOnClickListener {
            val monIntent=Intent().apply {
                putExtra("ret",text_input.text.toString())
            }
            setResult(Activity.RESULT_OK, monIntent)
            finish()
        }


    }
}