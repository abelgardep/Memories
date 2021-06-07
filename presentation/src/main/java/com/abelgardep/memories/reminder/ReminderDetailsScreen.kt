package com.abelgardep.memories.reminder

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


@Composable
fun ReminderDetailsScreen(
    navigateUp: () -> Unit,
    reminderId: String
) {
    Button(
        onClick = { navigateUp() }
    ) {
        Text("Details $reminderId - Go back")
    }
}
