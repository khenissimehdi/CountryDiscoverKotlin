package com.example.countrydiscover


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.countrydiscover.data.Country
import com.example.countrydiscover.data.CountryRepo


@Composable
fun Home(navController: NavController) {
    val cats = remember {
        CountryRepo.getCats()
    }
    Scaffold { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            item {
                Header(
                    text = "Countries",
                    navController = navController,
                    iconImage = Icons.Filled.Home,
                    iconSize = 64.dp
                )
            }
            items(cats) { country ->
                CatListItem(country = country, navController = navController)
            }
        }

    }
}

@Composable
fun CatListItem(country: Country, navController: NavController) {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable {
                navController.navigate(route = Screen.CountryDetail.route + country.name)
            }
    ) {
        Image(
            painter = painterResource(id = country.countryImage ),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(MaterialTheme.shapes.small)
        )
        Column {
            Text(text = country.name, style = MaterialTheme.typography.h6)


        }
    }
}

@Composable
fun Header(
    text: String,
    modifier: Modifier = Modifier,
    navController: NavController,
    iconImage: ImageVector,
    iconSize: Dp
) {
    Surface(
        color = MaterialTheme.colors.onSurface.copy(.1f),
        contentColor = MaterialTheme.colors.primary,
        modifier = modifier.semantics { heading() }

    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(0.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
               ) {
            Button(
                onClick = { navController.navigate(route = Screen.Home.route) },
                colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    disabledElevation = 0.dp
                )

            ) {
                Icon(
                    iconImage,
                    contentDescription = null,
                    modifier = Modifier.size(iconSize),
                    tint = MaterialTheme.colors.primary,
                )
            }
            Text(
                text = text,
                style = MaterialTheme.typography.h2,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            )
        }

    }
}
