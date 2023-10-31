package uz.gita.contactworkteam.utils.service

import android.annotation.SuppressLint
import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.gita.contactworkteam.data.repository.AppRepository
import uz.gita.contactworkteam.utils.myTimber
import uz.gita.contactworkteam.utils.notification.NotificationHelper

@HiltWorker
class ContactWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters,
    private val repository: AppRepository
) : Worker(context, workerParameters) {
    private val notificationHelper by lazy { NotificationHelper(context) }
    private val scope = MainScope()
//    @Inject
//    lateinit var repository: AppRepository

    @SuppressLint("MissingPermission")
    override fun doWork(): Result {
        myTimber("do work")
        notificationHelper.notificationManagerCompat.notify(1, notificationHelper.getNotification())
        scope.launch {
            myTimber("scope")
            repository.insertAllContactsToAPi().onEach {

            }.launchIn(scope)
        }
        return Result.success()
    }
}