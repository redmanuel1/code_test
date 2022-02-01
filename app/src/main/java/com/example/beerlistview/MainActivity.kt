package com.example.beerlistview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.beerlistview.model.Beer
import com.example.beerlistview.ui.theme.BeerListViewTheme
import com.example.beerlistview.view.BeerItem
import com.example.beerlistview.viewModel.BeerViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val beerViewModel by viewModels<BeerViewModel>()
        super.onCreate(savedInstanceState)
        setContent {
            BeerListViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BeerList(beerList = beerViewModel.beerListResponse)
                    beerViewModel.getBeerList()
                }
            }
        }
    }
}

@Composable
fun BeerList(beerList: List<Beer>){
    LazyColumn{
        itemsIndexed(items = beerList){ index, item ->
            BeerItem(beer = item)
        }
    }
}
