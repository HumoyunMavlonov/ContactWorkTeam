package uz.gita.contactworkteam.utils.service

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
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
    val scope = MainScope()

    @SuppressLint("MissingPermission")
    override fun doWork(): Result {
        myTimber("do work")
        scope.launch {
            repository.getAllContacts().onEach { }.launchIn(scope)
        }
        notificationHelper.notificationManagerCompat.notify(1, notificationHelper.getNotification())

        return Result.success()
    }
}