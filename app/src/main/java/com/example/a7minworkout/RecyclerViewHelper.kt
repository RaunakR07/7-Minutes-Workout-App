package com.example.a7minworkout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycle_view_text.view.*

class RecyclerViewHelper (val context: Context, val dateList: ArrayList<String>) : RecyclerView.Adapter<RecyclerViewHelper.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val dateTextView = view.date_tv

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycle_view_text, parent, false))
    }

    override fun getItemCount(): Int {
        return dateList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val date = dateList[position]
        holder.dateTextView.text = date
        if(position%2==0){
            holder.dateTextView.setBackgroundResource(R.drawable.history_text_bg)
        }

    }
}
