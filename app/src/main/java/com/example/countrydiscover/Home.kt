package com.example.countrydiscover


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.countrydiscover.data.Country
import com.example.countrydiscover.data.CountryRepo


@Composable
fun Home() {
    val cats = remember {
        CountryRepo.getCats()
    }
    Scaffold { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            item {
                Header(text = "Countries !")
            }
            items(cats) { country ->
                CatListItem(country = country)
            }
        }

    }
}

@Composable
fun CatListItem(country: Country) {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = country.countryImage ),
            contentDescription = null,
            modifier = Modifier.size(80.dp).clip(MaterialTheme.shapes.small)
        )
        Column {
            Text(text = country.name, style = MaterialTheme.typography.h6)


        }
    }
}

@Composable
fun Header(text: String,
           modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colors.onSurface.copy(.1f),
        contentColor = MaterialTheme.colors.primary,
        modifier = modifier.semantics { heading() }

    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h2,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        )
    }
}
