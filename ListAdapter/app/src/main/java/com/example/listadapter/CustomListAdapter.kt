package com.example.listadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter

class CustomListAdapter(var context: Context, var arraylist : ArrayList<String>) : BaseAdapter() {


    override fun getCount(): Int {
        return arraylist.size
    }
    override fun getItem(position: Int): Any {
        return position
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(android.R.layout.list_content, parent, false)

        return convertView
    }


}