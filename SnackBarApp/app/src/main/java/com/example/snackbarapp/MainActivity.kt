package com.example.snackbarapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coordinatorLayout = findViewById(R.id.coordinateLayout)
        button = findViewById(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            val snackbar: Snackbar =
                Snackbar.make(coordinatorLayout, "Task Completed ", Snackbar.LENGTH_LONG)
            snackbar.setAction("Undo", View.OnClickListener {
                val snackbar2: Snackbar =
                    Snackbar.make(coordinatorLayout, "Task Terminated", Snackbar.LENGTH_LONG)
                snackbar2.setTextColor(Color.BLUE)
                snackbar2.setBackgroundTint(Color.RED)
                snackbar2.show()
            }).setActionTextColor(Color.GREEN)
            snackbar.show()
            SystemClock.sleep(2000)
        })
    }
}