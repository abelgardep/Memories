package com.abelgardep.memories.reminder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.abelgardep.memories.R
import com.abelgardep.memories.components.ActionEdit
import com.abelgardep.memories.components.BackIcon
import com.abelgardep.memories.components.BaseTopBar
import com.abelgardep.memories.components.WorkInProgressDialog
import com.abelgardep.memories.extensions.toLegibleStringLong
import com.abelgardep.memories.timeline.fakeReminder


@Composable
fun ReminderDetailsScreen(
    navigateUp: () -> Unit,
    reminderId: String
) {
    var showWorkInProgressDialog by rememberSaveable { mutableStateOf(false) }
    if (showWorkInProgressDialog) {
        WorkInProgressDialog(onDismiss = { showWorkInProgressDialog = false })
    }

    Scaffold(
        topBar = {
            BaseTopBar(
                title = { Text(text = stringResource(id = R.string.reminder_details_title)) },
                navigationIcon = {
                    BackIcon(onBackClick = { navigateUp() })
                },
                actions = { ActionEdit(onEditClick = { showWorkInProgressDialog = true }) }
            )
        },
        content = { ReminderDetailsContent(reminderId) }
    )

}

@Composable
fun ReminderDetailsContent(
    reminderId: String
) {
    val reminder = fakeReminder // viewmodel.getReminder(id = reminderId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
            .padding(16.dp)
    ) {
        Text(text = reminder.name, style = MaterialTheme.typography.h3)
        Text(
            text = reminder.date.toLegibleStringLong(),
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )
        Divider(color = MaterialTheme.colors.secondary)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = reminder.description.orEmpty(), style = MaterialTheme.typography.body1)
    }
}
