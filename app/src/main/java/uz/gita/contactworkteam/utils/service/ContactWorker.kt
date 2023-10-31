package uz.gita.contactworkteam.utils.service

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import uz.gita.contactworkteam.data.repository.AppRepository
import uz.gita.contactworkteam.utils.myTimber
import uz.gita.contactworkteam.utils.notification.NotificationHelper
import javax.inject.Inject

class ContactWorker @Inject constructor(
    val context: Context, workerParameters: WorkerParameters,
    val repository: AppRepository
) :
    Worker(context, workerParameters) {
    private val notificationHelper by lazy { NotificationHelper(context) }
    private val scope = MainScope()

    @SuppressLint("MissingPermission")
    override fun doWork(): Result {
        myTimber("do work")
        notificationHelper.notificationManagerCompat.notify(1, notificationHelper.getNotification())
        scope.launch {
            repository.insertAllContactsToAPi()
        }
        return Result.success()
    }
}