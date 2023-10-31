package uz.gita.contactworkteam.presenter.screens.settings

import kotlinx.coroutines.flow.StateFlow

interface SettingContract {
    interface ViewModel {
        val uiState: StateFlow<SettingContract.UiState>
        fun onEventDispatcher(intent: SettingContract.Intent)
    }

    data class UiState(
        val message: String = ""
    )

    interface Intent {
        object Back : Intent
        object ClickCheckBox : Intent
    }

}