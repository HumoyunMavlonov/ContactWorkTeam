package uz.gita.contactworkteam.presenter.screens.settings

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.contactworkteam.ui.theme.ContactWorkTeamTheme
import uz.gita.contactworkteam.utils.service.ContactWorker
import java.util.concurrent.TimeUnit

class SettingsScreen : AndroidScreen() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val context = LocalContext.current
        val viewModel: SettingContract.ViewModel = getViewModel<SettingViewModel>()
        SettingContent(context = context, viewModel::onEventDispatcher)
    }
}

@ExperimentalMaterial3Api
@Composable
fun SettingContent(context: Context, onDispatcher: (SettingContract.Intent) -> Unit) {
    var hour by remember { mutableStateOf("") }
    val maxHour = 24
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(
                text = "Please input less than 24 hours!",
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.size(15.dp))
            OutlinedTextField(
                value = hour,
                onValueChange = {
                    if (it.toInt() <= maxHour || it == "")
                        hour = it
                },
                modifier = Modifier
                    .padding(horizontal = 25.dp, vertical = 10.dp)
                    .fillMaxWidth()
                    .height(56.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF0A459C),
                    unfocusedBorderColor = Color(0xFF7397CE),
                    cursorColor = Color(0xFF080809),
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = { "Hours" }
            )
            Spacer(modifier = Modifier.size(20.dp))

            Button(
                onClick = {
                    val periodicBuilder =
                        PeriodicWorkRequestBuilder<ContactWorker>(
                            hour.toInt().toLong(),
                            TimeUnit.HOURS
                        ).build()
                    WorkManager.getInstance(context).enqueue(periodicBuilder)
                    onDispatcher.invoke(SettingContract.Intent.Back)
                    Toast.makeText(context, "check the list after $hour", Toast.LENGTH_SHORT).show()


                },
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text(
                    text = "Set time",
                    fontSize = 22.sp,
                )
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun SettingsPrev() {
    ContactWorkTeamTheme() {

    }
}