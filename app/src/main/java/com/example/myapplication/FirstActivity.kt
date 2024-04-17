package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class FirstActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.p41_activity)
        val myImageView: ImageView = findViewById(R.id.imageView3)
        val textV: TextView = findViewById((R.id.text))
        val intent = Intent(this,SecondActivity::class.java)
        val message = "Натисніть на картинку!"
        val duration = Toast.LENGTH_SHORT // або Toast.LENGTH_LONG
        val toast = Toast.makeText(applicationContext, message, duration)
        myImageView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                textV.setText("Спрашиваю у жени, гдє ти бєрьош деньгі? А она мне говорит... ")
            }
        })
        textV.setOnClickListener {
            if (textV.text == "Спрашиваю у жени, гдє ти бєрьош деньгі? А она мне говорит... ")
                startActivity(intent)
            else
                toast.show()
        }
    }

}