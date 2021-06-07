package com.abelgardep.memories.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.abelgardep.memories.reminder.ReminderDetailsScreen


fun NavGraphBuilder.addReminderDetailsGraph(navController: NavController) {
    composable(ScreenDestination.Details.route) { backStackEntry ->
        val reminderId = backStackEntry.arguments?.getString("reminderId")
        requireNotNull(reminderId) { "reminderId parameter wasn't found. Please make sure it's set!" }
        ReminderDetailsScreen(
            navigateUp = { navController.popBackStack() },
            reminderId
        )
    }
}
