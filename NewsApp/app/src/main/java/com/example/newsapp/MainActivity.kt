package com.example.newsapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity(), OnItemClickListener {
    lateinit var myRecycleViewAdapter: MyRecycleViewAdapter
    lateinit var recyclerView :RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myRecycleViewAdapter= MyRecycleViewAdapter(this)
         recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=myRecycleViewAdapter
        fectchData()
    }
 fun fectchData(){
     var list = ArrayList<News>()
         val queue = Volley.newRequestQueue(this)

     val url : String ="https://newsapi.org/v2/everything?q=tesla&from=2021-07-15&sortBy=publishedAt&apiKey=f5cd498bf1ed4abaa3acd25694c95808"

     val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
         { response ->
             var jsonArray=response.getJSONArray("articles")
//             for(i in list.indices){
//
//             }
             Log.d("sorabh",jsonArray.toString())
         },
         { error ->
             Log.d("sorabh","--------------------------------------------")
         }
     )

    queue.add(jsonObjectRequest)
     myRecycleViewAdapter.updateData(list)
     }

    override fun onItemClicked(news: News) {
        Toast.makeText(
            this,
            "sorabh kumar the billanior " ,Toast.LENGTH_SHORT).show()
    }
}