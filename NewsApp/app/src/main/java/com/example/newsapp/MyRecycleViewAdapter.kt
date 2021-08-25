package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecycleViewAdapter(val listner : OnItemClickListener) : RecyclerView.Adapter<NewsHolder>() {
    val arrayList = ArrayList<News>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
val view =LayoutInflater.from(parent.context).inflate(R.layout.news_layout,parent,false)
        val newsHolder = NewsHolder(view)
        view.setOnClickListener { listner.onItemClicked(arrayList[newsHolder.adapterPosition]) }
        return  newsHolder
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.author.text=arrayList[position].author
        holder.title.text = arrayList[position].title
    }

    override fun getItemCount(): Int {
        return  arrayList.size
    }

    fun updateData(updateNews: ArrayList<News>) {
        arrayList.clear()
        arrayList.addAll(updateNews)
        notifyDataSetChanged()

    }


}
class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
var title : TextView = itemView.findViewById(R.id.title)
    var author : TextView =itemView.findViewById(R.id.author)
}
interface  OnItemClickListener{
    fun onItemClicked(news: News)
}