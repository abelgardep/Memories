package com.abelgardep.memories.timeline

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abelgardep.memories.R
import com.abelgardep.memories.domain.model.Reminder
import com.abelgardep.memories.ui.theme.MemoriesTheme
import java.time.LocalDate


@Composable
fun TimelineScreen(
    showReminderDetails: (reminderId: String) -> Unit,
    onAddNewReminderClick: () -> Unit
) {
    Scaffold(
        content = {
            TimelineScreenContent(showReminderDetails = showReminderDetails)
        },
        floatingActionButton = {
            AddNewReminderFAB(onAddNewReminderClick = onAddNewReminderClick)
        },
        floatingActionButtonPosition = FabPosition.End
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TimelineScreenContent(
    showReminderDetails: (reminderId: String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp, 16.dp, 16.dp, 80.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val remindersGroupedByMonth = fakeList.groupBy { it.date.month }
        remindersGroupedByMonth.forEach { (month, remindersInMonth) ->
            stickyHeader {
                ReminderStickyHeader(month = month, remindersInMonth = remindersInMonth.size)
            }
            items(remindersInMonth) {
                ReminderItem(
                    reminder = it,
                    onReminderClick = { reminder: Reminder -> showReminderDetails(reminder.id.toString()) })
            }
        }
    }
}

@Composable
fun AddNewReminderFAB(
    onAddNewReminderClick: () -> Unit
) {
    ExtendedFloatingActionButton(
        text = { Text(stringResource(id = R.string.timeline_add_new_reminder_fab)) },
        icon = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(id = R.string.timeline_add_new_reminder_fab)
            )
        },
        onClick = onAddNewReminderClick
    )
}

@Preview
@Composable
fun TimeLineScreenPreview() {
    MemoriesTheme {
        TimelineScreen(showReminderDetails = {}, onAddNewReminderClick = {})
    }
}

val fakeReminder = Reminder(
    1,
    "Lorem ipsum dolor sit amet",
    "Pellentesque molestie faucibus arcu sit amet convallis. Maecenas diam ligula, blandit vitae euismod vel, sollicitudin nec ligula. Aenean eget malesuada urna. Curabitur eget dolor urna. Cras feugiat suscipit dui et commodo. Duis ut molestie ex, sit amet varius ex. In suscipit semper nulla eget cursus. Aliquam eget ultrices odio. In cursus erat id enim dignissim eleifend. Maecenas rutrum sem at leo scelerisque consectetur. In et varius tortor, at mollis enim. Curabitur rhoncus congue varius. Nullam feugiat lectus auctor porta mattis. Nulla ac eros id sapien ullamcorper mattis a nec diam. Aliquam sodales, nisl sit amet pharetra ultrices, lacus augue finibus ligula, a bibendum mi lectus eget magna.",
    LocalDate.of(2014, 5, 24)
)

val fakeList = listOf(
    fakeReminder.copy(id = 1, date = LocalDate.of(2014, 5, 24)),
    fakeReminder.copy(2, date = LocalDate.of(2016, 5, 28)),
    fakeReminder.copy(3, date = LocalDate.of(2017, 6, 3)),
    fakeReminder.copy(4, date = LocalDate.of(2018, 5, 26)),
    fakeReminder.copy(5, date = LocalDate.of(2020, 1, 24)),
    fakeReminder.copy(6, date = LocalDate.of(2021, 2, 5)),
    fakeReminder.copy(7, date = LocalDate.of(2010, 1, 1)),
    fakeReminder.copy(8, date = LocalDate.of(1990, 1, 1)),
)
