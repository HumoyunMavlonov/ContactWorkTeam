package uz.gita.contactworkteam.presenter.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val direction: SettingDirection
) : SettingContract.ViewModel, ViewModel() {
    override val uiState = MutableStateFlow<SettingContract.UiState>(SettingContract.UiState())


    override fun onEventDispatcher(intent: SettingContract.Intent) {
        when (intent) {
            SettingContract.Intent.Back -> {
                viewModelScope.launch {
                    direction.back()
                }
            }
        }
    }
}