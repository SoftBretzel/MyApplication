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

class threeButtons : AppCompatActivity(), View.OnClickListener{git
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_buttons)

        button5.setOnClickListener {
            val inflater = layoutInflater
            val layout: View = inflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_container))
            val text: TextView = layout.findViewById(R.id.text)
            text.text="Vous avez cliqué que le bouton 5"
            with(Toast(applicationContext)){
                setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                duration= Toast.LENGTH_LONG
                view = layout
                show()
            }
        }

        button6.setOnClickListener (this)


    }

    override fun onClick(v: View?) {
        if(v==button6){
            Toast.makeText(this@threeButtons, "Vous avez cliqué sur le bouton 6", Toast.LENGTH_SHORT).show()
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