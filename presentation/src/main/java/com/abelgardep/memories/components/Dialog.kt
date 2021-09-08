package com.abelgardep.memories.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import com.abelgardep.memories.MainActivity
import com.abelgardep.memories.R
import com.google.android.material.datepicker.MaterialDatePicker
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*
import java.util.concurrent.TimeUnit


@Composable
fun WorkInProgressDialog(
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Work in progress") },
        text = { Text(text = "We are working to bring this functionality as soon as possible") },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "CLOSE")
            }
        }
    )
}

/**
 * Shows a outlined text field that shows a dialog when focusing the first time.
 * Should be done when clicking but I was not able to do it.
 * To be done when a better approach is found.
 */
@Composable
fun OutlinedTextFieldWithDatePicker(
    label: String,
    currentState: String,
    onDateSet: (date: LocalDate) -> Unit,
) {
    val context = LocalContext.current as MainActivity

    val materialAlertDialog = MaterialDatePicker.Builder.datePicker()
        .setTitleText(R.string.add_new_reminder_date)
        .setSelection(Date().time)
        .build()

    materialAlertDialog.addOnPositiveButtonClickListener {
        val selectedDateInSeconds = TimeUnit.SECONDS.convert(it, TimeUnit.MILLISECONDS)
        onDateSet(
            LocalDateTime.ofEpochSecond(selectedDateInSeconds, 0, ZoneOffset.UTC).toLocalDate()
        )
    }

    OutlinedTextField(
        readOnly = true,
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged {
                if (it.isFocused) materialAlertDialog.show(context.supportFragmentManager, null)
            },
        value = currentState,
        onValueChange = { materialAlertDialog.dismiss() },
        label = { Text(label) }
    )
}
