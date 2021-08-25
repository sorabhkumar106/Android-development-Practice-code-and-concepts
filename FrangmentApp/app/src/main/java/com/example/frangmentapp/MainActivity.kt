package com.example.frangmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(){
    lateinit var linearLayout: LinearLayout
    lateinit var button2: Button
    lateinit var button1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        linearLayout = findViewById(R.id.layout)

      button1.setOnClickListener(View.OnClickListener {
          var tataFragment :TataFragment= TataFragment()
          supportFragmentManager.beginTransaction()
              .replace(R.id.layout,tataFragment)
              .commit()
      })
        button2.setOnClickListener ( View.OnClickListener {
            var hdfcFragment :HdfcFragment= HdfcFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.layout,hdfcFragment)
                .commit()
        } )



    }
}


