package com.example.countrydiscover

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.countrydiscover.data.CountryDetailData
import com.example.countrydiscover.data.CountryRepo

@Composable
fun RankedValueDisplayer(value: Float, unit: String, rank: QuantitativeFact.Rank) {
    Box(contentAlignment = Alignment.CenterStart,   modifier = Modifier
        .height(40.dp)
        .fillMaxSize()) {
        Text(text = "test", style = MaterialTheme.typography.subtitle2 , color = Color.Black,   modifier = Modifier.align(
            Alignment.CenterEnd).padding(8.dp))
        Box(contentAlignment = Alignment.CenterStart,   modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(rank.ratio)
            .background(
                Color.Yellow
            )) {
            Text(text = "test", style = MaterialTheme.typography.subtitle2 , color = Color.Green,   modifier = Modifier.padding(8.dp))

        }
    }
}
@Composable
fun CountryDetail(navController: NavController, countryData: CountryDetailData) {

    Scaffold { innerPadding ->

        LazyColumn(contentPadding = innerPadding) {
            item {
                Header(
                    text =  countryData.name,
                    navController = navController,
                    iconImage = Icons.Filled.ArrowBack,
                    iconSize = 32.dp
                )

                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)) {
                        Image(painter = painterResource(id = countryData.flagImage), contentDescription = null)
                        Image(painter = painterResource(id = R.drawable.paris), contentDescription = null)
                    }
                }
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)) {
                        Text(text = "test",style = MaterialTheme.typography.subtitle2)
                        RankedValueDisplayer(Float.MAX_VALUE,"h", QuantitativeFact.Rank(200, 400))
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)) {
                        Text(text = "test",style = MaterialTheme.typography.subtitle2)
                        RankedValueDisplayer(Float.MAX_VALUE,"h", QuantitativeFact.Rank(200, 400))
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)) {
                        Text(text = "test",style = MaterialTheme.typography.subtitle2)
                        RankedValueDisplayer(Float.MAX_VALUE,"h", QuantitativeFact.Rank(200, 400))
                    }
                }

               


            }
        }
    }
}