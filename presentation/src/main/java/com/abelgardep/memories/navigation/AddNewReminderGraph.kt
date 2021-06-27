package com.abelgardep.memories.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.abelgardep.memories.addreminder.AddNewReminderScreen
import com.abelgardep.memories.addreminder.AddReminderViewModel


fun NavGraphBuilder.addNewReminderGraph(navController: NavController) {
    composable(ScreenDestination.AddNewReminder.route) {
        val addReminderViewModel = hiltViewModel<AddReminderViewModel>()
        AddNewReminderScreen(
            addReminderViewModel = addReminderViewModel,
            navigateUp = { navController.popBackStack() },
        )
    }
}
