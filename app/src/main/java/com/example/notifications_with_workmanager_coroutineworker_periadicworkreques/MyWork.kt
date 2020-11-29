package com.example.notifications_with_workmanager_coroutineworker_periadicworkreques

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay
import java.lang.Exception

class MyWork(c: Context, wp: WorkerParameters) : CoroutineWorker(c, wp) {

    override suspend fun doWork(): Result {

        try {
            //where you have some kind of the manipulations where you have some of the manipulations through which you could have some
            var nm = NotificationManagerCompat.from(applicationContext)
            var n1 = NotificationCompat.Builder(applicationContext, App.id)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("helllo...")
                .setContentText("how are you dude there.......will you come to there....to have some things...")
                .setOnlyAlertOnce(true)
                .setColor(Color.RED)
                .setContentIntent(
                    PendingIntent.getActivity(
                        applicationContext, 1,
                        Intent(applicationContext, MainActivity::class.java), 0
                    )
                )
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .setBigContentTitle("this is big content title")
                        .bigText(
                            "this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications"
                        )
                        .setSummaryText("user1")
                )
            nm.notify(1, n1.build())
            return Result.success()
        } catch (e: Exception) {
            return Result.failure()
        }


    }
}