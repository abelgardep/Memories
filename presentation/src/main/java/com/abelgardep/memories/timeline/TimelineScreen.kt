package com.abelgardep.memories.timeline

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.abelgardep.memories.navigation.ScreenDestination


@Composable
fun TimelineScreen(
    navController: NavController
) {
    Button(
        onClick = { navController.navigate(ScreenDestination.Details.createRoute("123")) }
    ) {
        Text("Timeline")
    }
}
