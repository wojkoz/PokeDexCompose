package com.example.pokecompose.ui.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

private val pokelist = listOf(Poke(id = 0, title = "pikachu"), Poke(id = 1, title = "pika"), Poke(id = 2, title = "pikachu2"), Poke(id = 3, title = "pikachu2"), Poke(id = 4, title = "pikachu2"))

@Composable
fun PokemonList() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(pokelist) {
            Box(modifier = Modifier
                .padding(top = 200.dp)
                .clickable {
                Log.e("BoxClicable", it.title)
            }) {
                Text(
                    text = it.title,
                    textAlign = TextAlign.Center,
                    color = Color.DarkGray,
                )
            }
        }
    }
}

data class Poke(
    val id: Long,
    val title: String,
)