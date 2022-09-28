package com.example.ch08

import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Button
import android.widget.Chronometer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var pauseTime = 0L
    var initTime = 0L

    lateinit var startButton: Button
    lateinit var stopButton: Button
    lateinit var resetButton: Button
    lateinit var chronometer: Chronometer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.startbutton)
        stopButton = findViewById(R.id.stopbutton)
        resetButton = findViewById(R.id.resetbutton)
        chronometer = findViewById(R.id.chronometer)

        startButton.setOnClickListener()
        {
            chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            chronometer.start()
            stopButton.isEnabled=true
            resetButton.isEnabled=true
            startButton.isEnabled=false
        }

        stopButton.setOnClickListener()
        {
            pauseTime = chronometer.base - SystemClock.elapsedRealtime()
            chronometer.stop()
            stopButton.isEnabled=false
            resetButton.isEnabled=true
            startButton.isEnabled=true
        }

        resetButton.setOnClickListener()
        {
            pauseTime = 0L
            chronometer.base = SystemClock.elapsedRealtime()
            chronometer.stop()
            stopButton.isEnabled=false
            resetButton.isEnabled=false
            startButton.isEnabled=true
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            if(System.currentTimeMillis() - initTime >3000)
            {
                Toast.makeText(this,"종료하려면 한번 더 눌러주세요", Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis()
                return true;
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}