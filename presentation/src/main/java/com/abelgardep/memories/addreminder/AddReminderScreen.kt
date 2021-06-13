package com.abelgardep.memories.addreminder

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.abelgardep.memories.R
import com.abelgardep.memories.components.BackIcon
import com.abelgardep.memories.components.BaseTopBar


@Composable
fun AddNewReminderScreen(
    navigateUp: () -> Unit,
) {
    Scaffold(
        topBar = {
            BaseTopBar(
                title = { Text(text = stringResource(id = R.string.add_new_reminder_title)) },
                navigationIcon = {
                    BackIcon(onBackClick = { navigateUp() })
                },
                actions = { }
            )
        },
        content = { AddReminderContent() }
    )
}

@Composable
fun AddReminderContent() {

}
