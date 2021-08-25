package com.example.popupmenuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showPopUp(view: View) {
        var popupMenu: PopupMenu = PopupMenu(this, view)
        popupMenu.setOnMenuItemClickListener(this)
        popupMenu.inflate(R.menu.menu_popup)
        popupMenu.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        var id: Int = item!!.itemId
        if (id == R.id.share) {
            Toast.makeText(applicationContext, "Sharing ", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.forword) {
            Toast.makeText(applicationContext, "forwording", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.setting) {

            Toast.makeText(applicationContext, "Setting", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }
}