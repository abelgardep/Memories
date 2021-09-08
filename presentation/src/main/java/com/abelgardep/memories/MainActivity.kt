package com.abelgardep.memories

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.abelgardep.memories.navigation.ScreenDestination
import com.abelgardep.memories.navigation.addNewReminderGraph
import com.abelgardep.memories.navigation.addReminderDetailsGraph
import com.abelgardep.memories.navigation.addTimelineGraph
import com.abelgardep.memories.timeline.TimelineScreen
import com.abelgardep.memories.ui.theme.MemoriesTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            MemoriesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavHost(
                        navController = navController,
                        startDestination = ScreenDestination.Timeline.route
                    ) {
                        addTimelineGraph(navController)
                        addReminderDetailsGraph(navController)
                        addNewReminderGraph(navController)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MemoriesTheme {
        TimelineScreen(hiltViewModel(), showReminderDetails = {}, onAddNewReminderClick = {})
    }
}
