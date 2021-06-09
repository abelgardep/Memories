package com.abelgardep.memories.timeline

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abelgardep.memories.R
import com.abelgardep.memories.extensions.toLegibleStringLong
import com.abelgardep.memories.ui.theme.MemoriesTheme
import java.time.Month


@Composable
fun ReminderStickyHeader(
    month: Month,
    remindersInMonth: Int,
    modifier: Modifier = Modifier
) {
    Card(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        shape = RoundedCornerShape(topEnd = 16.dp, bottomStart = 16.dp)
    ) {
        Row(
            modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            Text(
                modifier = Modifier
                    .align(CenterVertically)
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start),
                text = month.toLegibleStringLong(),
                style = MaterialTheme.typography.subtitle1,
            )
            Text(
                modifier = Modifier
                    .align(CenterVertically)
                    .weight(1f)
                    .wrapContentWidth(Alignment.End),
                text = stringResource(id = R.string.reminder_sticky_header_reminders_in_month, remindersInMonth),
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}

@Preview
@Composable
fun ReminderStickyHeaderPreview() {
    MemoriesTheme {
        ReminderStickyHeader(month = Month.APRIL, remindersInMonth = 4)
    }
}
