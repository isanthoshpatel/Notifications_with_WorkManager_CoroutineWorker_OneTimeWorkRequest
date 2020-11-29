package com.example.notifications_with_workmanager_coroutineworker_periadicworkreques

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var work1: OneTimeWorkRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       bt_mywork.setOnClickListener {
           work1 = OneTimeWorkRequest.Builder(MyWork::class.java).setConstraints(
               Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
           ).build()
           WorkManager.getInstance(this).enqueue(work1)
       }
    }

    override fun onStop() {
        super.onStop()
        work1 = OneTimeWorkRequest.Builder(MyWork::class.java).build()
        WorkManager.getInstance(this).enqueue(work1)
    }

    override fun onPause() {
        super.onPause()
        work1 = OneTimeWorkRequest.Builder(MyWork::class.java).build()
        WorkManager.getInstance(this).enqueue(work1)
    }
}
