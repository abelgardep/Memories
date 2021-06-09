package com.abelgardep.memories.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.abelgardep.memories.timeline.TimelineScreen


fun NavGraphBuilder.addTimelineGraph(navController: NavController) {
    composable(ScreenDestination.Timeline.route) {
        TimelineScreen(
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
