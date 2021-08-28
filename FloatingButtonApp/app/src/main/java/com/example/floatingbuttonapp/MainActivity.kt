package com.example.floatingbuttonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
   lateinit var floatingActionButton : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        floatingActionButton= findViewById(R.id.floating_action_button)
        floatingActionButton.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext,"this floating Action button",Toast.LENGTH_SHORT).show()
        })

    }
}