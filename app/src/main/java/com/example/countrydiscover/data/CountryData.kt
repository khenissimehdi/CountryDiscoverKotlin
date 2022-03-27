package com.example.countrydiscover.data

import androidx.annotation.DrawableRes
import com.example.countrydiscover.R

data class Country(
    val name: String,
    val id: Int,
    @DrawableRes val countryImage: Int,
)

data class CountryDetailData(val id: Int) {
    val name: String = countryNames[id]
    val area: String = ""
    val density: String = ""
    val gdp: String = ""
    @DrawableRes val flagImage: Int = image[id]
    @DrawableRes val famousImage: Int = image[id]
}

private val countryNames = listOf(
    "France",
    "Italy",
    "Ireland",
    "Japan",
    "Jamaica",
    "Russia",
    "Ukraine",
    "Poland",
    "Indonesia"
)


private val image = listOf(
    R.drawable.france,
    R.drawable.italie,
    R.drawable.irlande,
    R.drawable.japon,
    R.drawable.jamaique,
    R.drawable.russie,
    R.drawable.ukraine,
    R.drawable.pologne,
    R.drawable.indonesie
)

private fun countries(): List<Country> {
    val cats = mutableListOf<Country>()
    for ((index, country) in countryNames.withIndex()) {
        cats.add(Country(country, index, image[index]))
    }
    return cats
}



object CountryRepo {
    fun getCats(): List<Country> = countries()
}