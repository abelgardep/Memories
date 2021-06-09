package com.abelgardep.memories.navigation


/**
 * Awesome article about compose navigation
 * https://jossiwolf.medium.com/navigating-in-jetpack-compose-78c78d365c6a
 */
sealed class ScreenDestination(val route: String) {
    object Timeline : ScreenDestination("timeline")
    object Details : ScreenDestination("{reminderId}/details") {
        fun createRoute(reminderId: String) = "$reminderId/details"
    }
    object AddNewReminder : ScreenDestination("addNewReminder")
}
