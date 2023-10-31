package uz.gita.contactworkteam.presenter.screens.settings

import uz.gita.contactworkteam.navigator.AppNavigator
import javax.inject.Inject


interface SettingDirection {
    suspend fun back()
}

class SettingDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : SettingDirection {
    override suspend fun back() {
        appNavigator.back()
    }

}