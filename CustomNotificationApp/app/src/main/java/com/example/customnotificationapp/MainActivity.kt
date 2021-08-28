package com.example.customnotificationapp

import android.annotation.SuppressLint
import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            val layout = this.layoutInflater.inflate(R.layout.custom_layout,findViewById(R.id.custom))
            var textView :TextView =layout.findViewById(R.id.textView)
            textView.setText("sorabh kumar is legend")
            var toast : Toast = Toast(applicationContext)
            toast.duration = Toast.LENGTH_SHORT
            toast.view = layout
            toast.show()
        })
    }
}