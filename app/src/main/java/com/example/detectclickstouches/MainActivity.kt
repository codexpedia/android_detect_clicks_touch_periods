package com.example.detectclickstouches

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var timeElapsed = 0L
    private var clickCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initClicksListener()
        initTouchListener()
    }

    private fun initClicksListener() {
        tv_clicks.setOnClickListener {
            clickCounter++
            Log.d("setOnTouchListener", "Number of Clicks: " + clickCounter)
            Toast.makeText(applicationContext, "Number of Clicks: " + clickCounter, Toast.LENGTH_SHORT).show()
            //TODO do something when a certain number clicks is done
        }
    }

    private fun initTouchListener() {
        tv_touches.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    timeElapsed = event.downTime
                    Log.d("setOnTouchListener", "ACTION_DOWN at>>>" + event.downTime)
                }
                MotionEvent.ACTION_UP -> {
                    timeElapsed = event.eventTime - timeElapsed
                    Log.d("setOnTouchListener", "ACTION_UP at>>>" + event.eventTime)
                    Log.d("setOnTouchListener", "Period of time the view is pressed>>>" + timeElapsed)
                    Toast.makeText(applicationContext, "Period of time the view is pressed in milliseconds>>>" + timeElapsed, Toast.LENGTH_SHORT).show()
                    timeElapsed = 0L
                }
                else -> {
                }
            }//TODO do something when a certain period of time has passed
            true
        }
    }
}
