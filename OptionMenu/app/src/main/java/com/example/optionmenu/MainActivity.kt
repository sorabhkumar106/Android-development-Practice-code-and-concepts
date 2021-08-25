package com.example.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import org.jetbrains.annotations.NotNull

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreatePanelMenu(featureId: Int,@NotNull menu: Menu): Boolean {
        var menuInflater: MenuInflater  = menuInflater
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreatePanelMenu(featureId, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id :Int =item.itemId
        if (id==R.id.adani)
            Toast.makeText(applicationContext,"this Adani business power house",Toast.LENGTH_SHORT).show()
        else if (id==R.id.bajaj)
            Toast.makeText(applicationContext,"this bajaj business power house",Toast.LENGTH_SHORT).show()
        else if (id==R.id.tata)
            Toast.makeText(applicationContext,"this the great tata business power house",Toast.LENGTH_SHORT).show()
        else if(id==R.id.birla)
            Toast.makeText(applicationContext,"this birlas business power house",Toast.LENGTH_SHORT).show()
else if (id==R.id.hdfc)
    Toast.makeText(applicationContext,"this finacial power hpuse of india ",Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)
    }
}