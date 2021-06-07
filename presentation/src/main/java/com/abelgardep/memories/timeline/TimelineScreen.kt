package com.abelgardep.memories.timeline

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


@Composable
fun TimelineScreen(
    showReminderDetails: (reminderId: String) -> Unit
) {
    Button(
        onClick = { showReminderDetails("123") }
    ) {
        Text("Timeline")
    }
}
