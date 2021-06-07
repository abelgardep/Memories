package com.abelgardep.memories.timeline

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun TimelineScreen(
    onReminderClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .clickable { onReminderClick() }
    ) {
        Text("Timeline")
    }
}
