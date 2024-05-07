package xyz.teamgravity.sharedelementtransitiondemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import xyz.teamgravity.sharedelementtransitiondemo.ui.theme.SharedElementTransitionDemoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SharedElementTransitionDemoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { padding ->
                    Surface(
                        color = MaterialTheme.colorScheme.background,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
                        val controller = rememberNavController()

                        SharedTransitionLayout {
                            NavHost(
                                navController = controller,
                                startDestination = Screen.List.route
                            ) {
                                composable(
                                    route = Screen.List.route
                                ) {
                                    ListScreen(
                                        sharedTransitionScope = this@SharedTransitionLayout,
                                        animatedVisibilityScope = this,
                                        onItemClick = { image: Int, text: String ->
                                            controller.navigate("${Screen.Detail.route}/$image/$text")
                                        }
                                    )
                                }
                                composable(
                                    route = "${Screen.Detail.route}/{${Screen.Detail.Args.IMAGE}}/{${Screen.Detail.Args.TEXT}}",
                                    arguments = listOf(
                                        navArgument(
                                            name = Screen.Detail.Args.IMAGE,
                                            builder = {
                                                type = NavType.IntType
                                            }
                                        ),
                                        navArgument(
                                            name = Screen.Detail.Args.TEXT,
                                            builder = {
                                                type = NavType.StringType
                                            }
                                        )
                                    )
                                ) { entry ->
                                    DetailScreen(
                                        image = entry.arguments?.getInt(Screen.Detail.Args.IMAGE) ?: 0,
                                        text = entry.arguments?.getString(Screen.Detail.Args.TEXT) ?: "",
                                        sharedTransitionScope = this@SharedTransitionLayout,
                                        animatedVisibilityScope = this
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}