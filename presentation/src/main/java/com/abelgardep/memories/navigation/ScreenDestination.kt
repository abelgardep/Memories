package com.abelgardep.memories.navigation


sealed class ScreenDestination(val route: String) {
    object Timeline : ScreenDestination("timeline")
    object Details : ScreenDestination("details")
}
