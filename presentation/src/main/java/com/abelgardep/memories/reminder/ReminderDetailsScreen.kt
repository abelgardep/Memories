package com.abelgardep.memories.reminder

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun ReminderDetailsScreen(
    navController: NavController
) {
    Button(
        onClick = { navController.popBackStack() }
    ) {
        Text("Details - Go back")
    }
}
