package com.abelgardep.memories.addreminder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abelgardep.memories.R
import com.abelgardep.memories.components.BackIcon
import com.abelgardep.memories.components.BaseTopBar
import com.abelgardep.memories.components.OutlinedTextFieldWithDatePicker
import com.abelgardep.memories.components.WorkInProgressDialog
import com.abelgardep.memories.extensions.toLegibleStringLong
import com.vanpra.composematerialdialogs.buttons
import com.vanpra.composematerialdialogs.datetime.datepicker.datepicker
import java.time.LocalDate


@Composable
fun AddNewReminderScreen(
    addReminderViewModel: AddReminderViewModel,
    navigateUp: () -> Unit,
) {

    var showWorkInProgressDialog by rememberSaveable { mutableStateOf(false) }
    if (showWorkInProgressDialog) {
        WorkInProgressDialog(onDismiss = { showWorkInProgressDialog = false })
    }

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
        content = { AddReminderContent(addReminderViewModel) }
    )
}

@Composable
fun AddReminderContent(
    addReminderViewModel: AddReminderViewModel
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
                label = stringResource(id = R.string.add_new_reminder_date)
            ) {
                datepicker(
                    title = stringResource(id = R.string.add_new_reminder_date),
                    waitForPositiveButton = false
                ) { localDate ->
                    addReminderViewModel.onDateSet(localDate)
                }

                buttons {
                    positiveButton(stringResource(id = R.string.global_ok))
                    negativeButton(stringResource(id = R.string.global_cancel))
                }
            }
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            enabled = buttonEnabledState,
            onClick = { addReminderViewModel.createReminder() }
        ) {
            Text(text = stringResource(id = R.string.global_done).uppercase())
        }
    }
}
