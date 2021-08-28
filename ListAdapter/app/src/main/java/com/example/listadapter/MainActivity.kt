package com.example.listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView : ListView =findViewById(R.id.listView)
        var array = ArrayList<String>(Arrays.asList("tcs","hcl","wipro","infosys"))
       val customListAdapter:CustomListAdapter  = CustomListAdapter(this,array)
        listView.adapter = customListAdapter
    }
}