package com.example.a7minworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class RecyclerViewActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_recycler_view)
        var dbObject = HistoryTableDBHelper(this, null)
        var dateList = dbObject.getAllDates()
        displayDates(dateList)

   }


    fun displayDates(dateList: ArrayList<String>) {
       var mainRecycler = RecyclerViewHelper(this, dateList)
        rv_name.layoutManager = LinearLayoutManager(this)
        rv_name.adapter = mainRecycler
    }
}



