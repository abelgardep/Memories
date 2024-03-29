package com.abelgardep.memories.addreminder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abelgardep.memories.R
import com.abelgardep.memories.components.BackIcon
import com.abelgardep.memories.components.BaseTopBar
import com.abelgardep.memories.components.OutlinedTextFieldWithDatePicker
import com.abelgardep.memories.extensions.toLegibleStringLong
import java.time.LocalDate


@Composable
fun AddNewReminderScreen(
    addReminderViewModel: AddReminderViewModel,
    navigateUp: () -> Unit,
    onNewReminderAdded: () -> Unit,
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
        content = { AddReminderContent(addReminderViewModel, onNewReminderAdded) }
    )
}

@Composable
fun AddReminderContent(
    addReminderViewModel: AddReminderViewModel,
    onNewReminderAdded: () -> Unit,
) {
    val nameState: String by addReminderViewModel.reminderName.observeAsState("")
    val dateState: LocalDate by addReminderViewModel.reminderDate.observeAsState(LocalDate.now())
    val descriptionState: String by addReminderViewModel.reminderDescription.observeAsState("")
    val buttonEnabledState: Boolean by addReminderViewModel.buttonEnabled.observeAsState(false)

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
            .padding(16.dp)
    ) {
        Column {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = nameState,
                maxLines = 1,
                onValueChange = { name -> addReminderViewModel.onNameChange(name) },
                label = { Text(stringResource(id = R.string.add_new_reminder_name)) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = descriptionState,
                onValueChange = { description ->
                    addReminderViewModel.onDescriptionChange(
                        description
                    )
                },
                label = { Text(stringResource(id = R.string.add_new_reminder_description)) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextFieldWithDatePicker(
                currentState = dateState.toLegibleStringLong(),
                label = stringResource(id = R.string.add_new_reminder_date),
                onDateSet = { date -> addReminderViewModel.onDateSet(date = date) }
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            enabled = buttonEnabledState,
            onClick = {
                addReminderViewModel.createReminder()
                onNewReminderAdded()
            }
        ) {
            Text(text = stringResource(id = R.string.global_done).uppercase())
        }
    }
}
