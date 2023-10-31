package uz.gita.contactworkteam.utils.service

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import uz.gita.contactworkteam.utils.myTimber
import uz.gita.contactworkteam.utils.notification.NotificationHelper

class ContactWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    private val notificationHelper by lazy { NotificationHelper(context) }

    @SuppressLint("MissingPermission")
    override fun doWork(): Result {
        myTimber("do work")
        notificationHelper.notificationManagerCompat.notify(1, notificationHelper.getNotification())
        return Result.success()
    }
}