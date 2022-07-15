package com.example.a7minworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recycler_view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        history_button_ll.setOnClickListener{
            val goToRecycler = Intent(this@MainActivity, RecyclerViewActivity::class.java)
            startActivity(goToRecycler)
        }


    }

    public fun homeToExercise(view: View) {
        val goToExercise = Intent(this, exercisepage::class.java)
        startActivity(goToExercise)
    }


}