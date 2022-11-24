package com.example.c79

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class MyService : JobService() {

    override fun onCreate() {
        super.onCreate()
        Log.d("kkang", "MyService...OnCreate...")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("kkang","MyService...OnDestroy")
    }

    override fun onStartJob(p0: JobParameters?): Boolean {
        Log.d("kkang","MyService...onStartJob")
        return false
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d("kkang","MyService...onStopJob")
        return false
    }
}