package com.abelgardep.memories.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.abelgardep.memories.timeline.TimelineScreen
import com.abelgardep.memories.timeline.TimelineViewModel


fun NavGraphBuilder.addTimelineGraph(navController: NavController) {
    composable(ScreenDestination.Timeline.route) {
        val timelineViewModel = hiltViewModel<TimelineViewModel>()
        TimelineScreen(
            timelineViewModel,
            showReminderDetails = { reminderId: String ->
                navController.navigate(
                    ScreenDestination.Details.createRoute(reminderId)
                )
            },
            onAddNewReminderClick = {
                navController.navigate(
                    ScreenDestination.AddNewReminder.route
                )
            }
        )
    }
}
