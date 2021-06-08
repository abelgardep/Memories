package com.abelgardep.memories.timeline

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abelgardep.memories.domain.model.Reminder
import com.abelgardep.memories.extensions.toLegibleStringLong
import java.time.LocalDate


typealias OnReminderClick = (Reminder) -> Unit


@Composable
fun ReminderItem(
    reminder: Reminder,
    onReminderClick: OnReminderClick,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = { onReminderClick(reminder) })
                .padding(16.dp)
        ) {
            ReminderDateItem(localDate = reminder.date, modifier = modifier)
            Spacer(modifier = Modifier.padding(8.dp))
            Column {
                Text(
                    text = reminder.name,
                    style = MaterialTheme.typography.h6,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = reminder.description ?: "",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun ReminderDateItem(
    localDate: LocalDate,
    modifier: Modifier
) {
    Column {
        Text(
            modifier = modifier.align(CenterHorizontally),
            text = localDate.dayOfMonth.toString(),
            style = MaterialTheme.typography.body2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = modifier.align(CenterHorizontally),
            text = localDate.month.toLegibleStringLong(),
            style = MaterialTheme.typography.body2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = modifier.align(CenterHorizontally),
            text = localDate.year.toString(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body2
        )
    }
}

@Preview
@Composable
fun ReminderItemPreview() {
    MaterialTheme {
        ReminderItem(reminder = fakeList.first(), {})
    }
}
