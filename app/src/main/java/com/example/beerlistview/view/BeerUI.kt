package com.example.beerlistview.view


import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.*

import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.example.beerlistview.model.Beer

@Composable
fun BeerItem(beer: Beer){
    Card(modifier = Modifier
        .padding(8.dp, 4.dp)
        .height(110.dp)
    )
    {
        Surface(
            color  = Color(218,235 , 240),
//            border = BorderStroke(1.dp, Color.Black),
//            shape = RoundedCornerShape(8.dp)

        ){
            Row( modifier = Modifier
                .padding(4.dp)
                .fillMaxSize()

            ){
                Image(
                    painter = rememberImagePainter(data = beer.image_url,
                        builder={
                    scale(Scale.FILL)
                } ),
                    contentDescription = beer.name,

                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.2f)
                )
                Column(verticalArrangement = Arrangement.Center, modifier = Modifier
                    .padding(4.dp)
                    .fillMaxHeight()
                    .weight(0.8f)){
                    Text(text = beer.name, fontWeight = FontWeight.Bold)
                    Text(text = beer.tagline)
                    Text(text = "First Brewed: " + beer.first_brewed, maxLines = 3)
                }

            }

        }
    }
}