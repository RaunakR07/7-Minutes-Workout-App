package com.example.a7minworkout

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_exercisepage.*
import java.text.SimpleDateFormat
import java.util.*

class exercisepage : AppCompatActivity() {
    private var timePass = 0
    private var restCountDown: CountDownTimer? = null
    private var mediaPlayer: MediaPlayer? = null
    private var finishmediaPlayer: MediaPlayer? = null
    private var exerciseCountDown: CountDownTimer? = null
    private var mCurrentExerciseIndex = -1
    var dbObject = HistoryTableDBHelper(this, null)
    private var mExerciseList = Exercises.ExercisesObj.getExercise()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercisepage)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setRestCountDown()
    }

    private fun setRestCountDown() {
        restCountDown = object : CountDownTimer(1000, 1000) {
            override fun onFinish() {
                // Toast.makeText(this@exercisepage, "over", Toast.LENGTH_SHORT).show()
                timePass = 0
                mCurrentExerciseIndex++

                    rest_ll.visibility = View.GONE
                    exercise_ll.visibility = View.VISIBLE
                    setExerciseCountDown()

            }

            override fun onTick(p0: Long) {
                timePass++
                rest_progressbar.progress = 10 - timePass
                rest_timer_time.text = (rest_progressbar.progress).toString()
                if (rest_progressbar.progress <=3 && rest_progressbar.progress >0)
                    tickSound()
                else if (rest_progressbar.progress == 0)
                    finishSound()
            }

        }.start()
    }


    private fun setExerciseCountDown() {
        exerciseCountDown = object : CountDownTimer(10000, 1000) {
            override fun onFinish() {
                //Toast.makeText(this@exercisepage, "over", Toast.LENGTH_SHORT).show()
                if (mCurrentExerciseIndex < 2){
                timePass = 0

                    rest_ll.visibility = View.VISIBLE
                exercise_ll.visibility = View.GONE
                setRestCountDown()
            }else {
                    var calendar = Calendar.getInstance()
                    var date = calendar.time
                    var sdf = SimpleDateFormat("yyyy/MM/dd HH:mm")
                    var dateString = sdf.format(date)
                    dbObject.addDates(dateString)


                    val exerciseTofinal = Intent(this@exercisepage, finalPage::class.java)
                    startActivity(exerciseTofinal)

                }




            }

            override fun onTick(p0: Long) {

                var exerciseObject = mExerciseList[mCurrentExerciseIndex]
                exercise_name.text = exerciseObject.exerciseName
                exercise_image.setImageResource(exerciseObject.exerciseImage)
                timePass++
                exercise_progressbar.progress = 30 - timePass
                exercise_timer_time.text = (exercise_progressbar.progress).toString()


            }

        }.start()
    }

    private fun tickSound() {
        mediaPlayer = MediaPlayer.create(this, R.raw.singleticksound)
        mediaPlayer?.start()
    }

    private fun finishSound() {
        finishmediaPlayer = MediaPlayer.create(this, R.raw.timerfinish)
        finishmediaPlayer?.start()
    }
}