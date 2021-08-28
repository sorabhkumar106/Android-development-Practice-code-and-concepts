package com.example.dialogfrangmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentManager
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button : Button =findViewById(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            showDialog()
        })
    }

    private fun showDialog() {
        val fragmentManager : FragmentManager = supportFragmentManager
        var myDialogFrangment : MyDialogFrangment = MyDialogFrangment()
        myDialogFrangment.show(fragmentManager,"thisjnnbcusyt")
    }
}