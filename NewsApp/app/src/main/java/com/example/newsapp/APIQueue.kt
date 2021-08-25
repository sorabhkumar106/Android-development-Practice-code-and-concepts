package com.example.newsapp

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.Volley

class APIQueue constructor(context: Context) {
    val newsPipline= Volley.newRequestQueue(context.applicationContext)
  companion object {
      @Volatile
      private var Instance: APIQueue? = null
      fun getInstance(context: Context): APIQueue {
          if (Instance == null)
              Instance = APIQueue(context)

          return this.Instance!!

      }
  }
      fun <T> addToQueue(request: Request<T>) {
          newsPipline.add(request)
      }

}