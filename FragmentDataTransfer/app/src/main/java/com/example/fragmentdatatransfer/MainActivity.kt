package com.example.fragmentdatatransfer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?): Unit = runBlocking{
            super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.Default).launch {
            var firstFragment: FirstFrangment = FirstFrangment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.layout, firstFragment)
                .commit()
        }
    }
}