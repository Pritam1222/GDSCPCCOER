package com.example.mcdonalds

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mcdonalds.ui.details.DetailsScreen
import com.example.mcdonalds.ui.home.HomeScreen
import com.example.mcdonalds.ui.menu.MenuScreen
import com.example.mcdonalds.ui.theme.McDonaldsTheme

@ExperimentalAnimationApi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            McDonaldsTheme(lightTheme = true) {

                val navController = rememberNavController()

                NavHost(navController, startDestination = "home") {

                    composable("home") {
                        HomeScreen(
                            onCategoryClick = { navController.navigate("menu") },
                            onMenuItemClick = { navController.navigate("menu") },
                        )
                    }

                    composable("menu") {
                        MenuScreen(
                            onBackClick = { navController.navigateUp() },
                            onMenuItemClick = { menuItemId ->
                                navController.navigate("details/$menuItemId")
                            },
                        )
                    }

                    composable(
                        "details/{menuItemId}",
                        arguments = listOf(navArgument("menuItemId") { type = NavType.LongType })
                    ) { backStackEntry ->
                        DetailsScreen(
                            menuItemId = backStackEntry.arguments!!.getLong("menuItemId"),
                            onBackClick = { navController.navigateUp() }
                        )
                    }

                }

            }
        }
    }
}
