package com.example.ratingbarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {
 lateinit   var button : Button
 lateinit var ratingBar: RatingBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button =findViewById(R.id.button)
        ratingBar = findViewById(R.id.ratingBar)
        button.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext,ratingBar.rating.toString(),Toast.LENGTH_SHORT).show()
        })
    }
}