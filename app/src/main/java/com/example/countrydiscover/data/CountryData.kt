package com.example.countrydiscover.data

import androidx.annotation.DrawableRes
import com.example.countrydiscover.R

data class Country(
    val name: String,
    @DrawableRes val countryImage: Int,
)

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
        cats.add(Country(country, image[index]))
    }
    return cats
}


object CountryRepo {
    fun getCats(): List<Country> = countries()
}