package uz.gita.contactworkteam.presenter.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.contactworkteam.ui.theme.ContactWorkTeamTheme

@Composable
fun SettingItem(
    text: String,
    onClick: () -> Unit,
    isChecked: Boolean,
    onValueChange: (Boolean) -> Unit,
    ClickCheckBox: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 10.dp)
            .fillMaxWidth()
            .height(90.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(modifier = Modifier.fillMaxSize()) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = onValueChange,
                    modifier = Modifier
                        .align(CenterVertically)
                        .padding(10.dp)
                        .clickable { ClickCheckBox() },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Magenta,
                        uncheckedColor = Color.White,
                        checkmarkColor = Color.LightGray
                    )
                )

                Column {
                    Text(
                        text = text, fontWeight = FontWeight.SemiBold, fontSize = 22.sp,
                        modifier = Modifier.padding(top = 10.dp)
                    )

                }

            }


        }
    }
}

@Composable
@Preview(showBackground = true)
fun SettingItemPrev() {
    ContactWorkTeamTheme() {
        SettingItem(
            "",
            onClick = { },
            onValueChange = {}, isChecked = true
        ) {}
    }
}