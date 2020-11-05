package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_three_buttons.*

class threeButtons : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_buttons)

        button5.setOnClickListener {
            Toast.makeText(this@threeButtons, "Vous avez cliqué sur le bouton 5", Toast.LENGTH_SHORT).show()
        }

        button6.setOnClickListener (this)


    }

    override fun onClick(v: View?) {
        if(v==button6){
           val inflater = layoutInflater
            val container: ViewGroup = findViewById(R.id.custom_toast_container)
            val layout: View = inflater.inflate(R.layout.custom_toast, container)
            val text: TextView = layout.findViewById(R.id.text)
            text.text="Vous avez cliqué que le bouton 6"
            with(Toast(applicationContext)){
                setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                duration= Toast.LENGTH_SHORT
                view = layout
                show()
            }
        }
    }

    fun Bouton7(view: View){
        val builder: AlertDialog.Builder? = DialogActivity@this?.let{
            AlertDialog.Builder(it)
        }
        builder?.setMessage("Vous avez cliqué sur le bouton 7")
            ?.setTitle("Bouton 7")
        val dialog: AlertDialog? = builder?.create()
        dialog?.show()
    }
}