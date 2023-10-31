package uz.gita.contactworkteam.presenter.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.contactworkteam.presenter.components.SettingItem

class SettingsScreen : AndroidScreen() {
    @Composable
    override fun Content() {

    }
}

@Composable
fun SettingContent() {
    var isCheckedFirst by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {
        SettingItem(
            text = "2 hour",
            onClick = { },
            isChecked = isCheckedFirst,
            onValueChange = { isCheckedFirst = it }) {
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SettingsPrev() {

}