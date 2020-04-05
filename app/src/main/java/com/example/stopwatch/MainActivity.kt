package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private var time = 0
    private var timerTask: Timer? = null // timerTask 변수를 null을 허용하는 Timer 타입 선언

    private fun start() {
        fab.setImageResource(R.drawable.ic_pause_black_24dp)

        timerTask = timer(period = 10) {

            time++

            val sec = time / 100
            val milli = time % 100

            runOnUiThread {
                secTextView.text = "$sec"
                milliTextView.text = "$milli"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
