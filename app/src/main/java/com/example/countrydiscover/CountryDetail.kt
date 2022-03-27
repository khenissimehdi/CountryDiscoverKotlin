package com.example.countrydiscover

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.countrydiscover.data.CountryRepo

@Composable
fun CountryDetail(navController: NavController, countryName: String) {

    Scaffold { innerPadding ->

        LazyColumn(contentPadding = innerPadding) {
            item {
                Header(
                    text = countryName,
                    navController = navController,
                    iconImage = Icons.Filled.ArrowBack,
                    iconSize = 32.dp
                )

            }
        }
    }
}