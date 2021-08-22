package com.abelgardep.memories.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.abelgardep.memories.reminder.ReminderDetailsScreen
import com.abelgardep.memories.reminder.ReminderDetailsViewModel


fun NavGraphBuilder.addReminderDetailsGraph(navController: NavController) {
    composable(ScreenDestination.Details.route) { backStackEntry ->
        val reminderId = backStackEntry.arguments?.getString("reminderId")?.toIntOrNull()
        requireNotNull(reminderId) { "reminderId parameter wasn't found. Please make sure it's set!" }
        val reminderDetailsViewModel = hiltViewModel<ReminderDetailsViewModel>()

        ReminderDetailsScreen(
            reminderDetailsViewModel,
            navigateUp = { navController.popBackStack() },
            reminderId = reminderId
        )
    }
}
