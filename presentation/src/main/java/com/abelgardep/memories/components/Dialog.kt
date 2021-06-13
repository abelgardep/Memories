package com.abelgardep.memories.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import com.vanpra.composematerialdialogs.MaterialDialog


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
    content: @Composable MaterialDialog.() -> Unit
) {
    val dialog = remember { MaterialDialog() }
    dialog.build(content = content)

    OutlinedTextField(
        readOnly = true,
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged { if (it.isFocused) dialog.show() },
        value = currentState,
        onValueChange = { dialog.hide() },
        label = { Text(label) }
    )
}
