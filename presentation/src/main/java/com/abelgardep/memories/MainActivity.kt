package com.abelgardep.memories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.abelgardep.memories.reminder.ReminderDetailsScreen
import com.abelgardep.memories.timeline.TimelineScreen
import com.abelgardep.memories.ui.theme.MemoriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MemoriesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavHost(navController = navController, startDestination = TIMELINE) {
                        composable(TIMELINE) {
                            TimelineScreen { navController.navigate(DETAILS) }
                        }
                        composable(DETAILS) {
                            ReminderDetailsScreen()
                        }
                    }
                }
            }
        }
    }

    private companion object {
        private const val DETAILS = "details"
        private const val TIMELINE = "timeline"
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MemoriesTheme {
        TimelineScreen()
    }
}
