package com.abelgardep.memories.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.abelgardep.memories.addreminder.AddNewReminderScreen


fun NavGraphBuilder.addNewReminderGraph(navController: NavController) {
    composable(ScreenDestination.AddNewReminder.route) {
        AddNewReminderScreen(
            navigateUp = { navController.popBackStack() },
        )
    }
}
