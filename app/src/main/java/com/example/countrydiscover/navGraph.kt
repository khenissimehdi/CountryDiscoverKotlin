package com.example.countrydiscover

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.countrydiscover.data.CountryDetailData

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
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) {
            CountryDetail(navController = navController, countryData = CountryDetailData(
                id = it.arguments?.getInt("id") ?: 0
            ))
        }
    }

}