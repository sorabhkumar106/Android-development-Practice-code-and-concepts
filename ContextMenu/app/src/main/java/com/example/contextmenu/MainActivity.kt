package com.example.contextmenu

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView=findViewById<TextView>(R.id.textView)
        registerForContextMenu(textView)
 
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        menuInflater.inflate(R.menu.context_menu , menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val itemId =item.itemId
        if (itemId==R.id.share)
            Toast.makeText(applicationContext,"Share To",Toast.LENGTH_SHORT).show()
        else if (itemId==R.id.forword)
            Toast.makeText(applicationContext,"Forword To",Toast.LENGTH_SHORT).show()
        else if (itemId==R.id.setting)
            Toast.makeText(applicationContext, "Setting", Toast.LENGTH_SHORT).show()
        return super.onContextItemSelected(item)
    }
}




