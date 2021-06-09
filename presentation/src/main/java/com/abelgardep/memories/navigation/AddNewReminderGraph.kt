package com.abelgardep.memories.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.abelgardep.memories.addreminder.AddNewReminderScreen


fun NavGraphBuilder.addNewReminderGraph() {
    composable(ScreenDestination.AddNewReminder.route) {
        AddNewReminderScreen()
    }
}
