package com.example.spinnerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.get
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var spinner = findViewById<Spinner>(R.id.spinner)
        val array = arrayOf("bob", "pnb", "boi", "sbi", "obc")
        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, array)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext,spinner.get(position).toString(),Toast.LENGTH_SHORT).show()

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

}


