package com.example.countrydiscover

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object CountryDetail: Screen(route = "country_screen/{name}")
}