package com.abelgardep.memories.timeline

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.abelgardep.memories.domain.model.Reminder
import java.time.LocalDate


@Composable
fun TimelineScreen(
    showReminderDetails: (reminderId: String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(fakeList) {
            ReminderItem(
                reminder = it,
                onReminderClick = { reminder: Reminder -> showReminderDetails(reminder.id.toString()) })
        }
    }
}

val fakeList = listOf(
    Reminder(
        1,
        "Lorem ipsum dolor sit amet",
        "Pellentesque molestie faucibus arcu sit amet convallis. Maecenas diam ligula, blandit vitae euismod vel, sollicitudin nec ligula. Aenean eget malesuada urna. Curabitur eget dolor urna. Cras feugiat suscipit dui et commodo. Duis ut molestie ex, sit amet varius ex. In suscipit semper nulla eget cursus. Aliquam eget ultrices odio. In cursus erat id enim dignissim eleifend. Maecenas rutrum sem at leo scelerisque consectetur. In et varius tortor, at mollis enim. Curabitur rhoncus congue varius. Nullam feugiat lectus auctor porta mattis. Nulla ac eros id sapien ullamcorper mattis a nec diam. Aliquam sodales, nisl sit amet pharetra ultrices, lacus augue finibus ligula, a bibendum mi lectus eget magna.",
        LocalDate.of(2014, 5, 24)
    ),
    Reminder(
        2,
        "Lorem ipsum dolor sit amet",
        "Pellentesque molestie faucibus arcu sit amet convallis. Maecenas diam ligula, blandit vitae euismod vel, sollicitudin nec ligula. Aenean eget malesuada urna. Curabitur eget dolor urna. Cras feugiat suscipit dui et commodo. Duis ut molestie ex, sit amet varius ex. In suscipit semper nulla eget cursus. Aliquam eget ultrices odio. In cursus erat id enim dignissim eleifend. Maecenas rutrum sem at leo scelerisque consectetur. In et varius tortor, at mollis enim. Curabitur rhoncus congue varius. Nullam feugiat lectus auctor porta mattis. Nulla ac eros id sapien ullamcorper mattis a nec diam. Aliquam sodales, nisl sit amet pharetra ultrices, lacus augue finibus ligula, a bibendum mi lectus eget magna.",
        LocalDate.of(2016, 5, 28)
    ),
    Reminder(3, "Lorem ipsum dolor sit amet", "b", LocalDate.of(2017, 6, 3)),
    Reminder(4, "Lorem ipsum dolor sit amet", "b", LocalDate.of(2018, 5, 26)),
    Reminder(5, "Lorem ipsum dolor sit amet", "b", LocalDate.of(2020, 1, 24)),
    Reminder(6, "Lorem ipsum dolor sit amet", "b", LocalDate.of(2021, 2, 5)),
    Reminder(7, "Lorem ipsum dolor sit amet", "b", LocalDate.of(2010, 1, 1)),
    Reminder(8, "Lorem ipsum dolor sit amet", "b", LocalDate.of(1990, 1, 1)),
)
