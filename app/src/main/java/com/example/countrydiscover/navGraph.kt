package com.example.countrydiscover

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
          Home(navController = navController)
        }
        composable(
            route = Screen.CountryDetail.route,
            arguments = listOf(navArgument("name") {
                type = NavType.StringType
            })
        ) {
            CountryDetail(navController = navController, it.arguments?.getString("name").toString().replace("{name}", ""))
        }
    }

}