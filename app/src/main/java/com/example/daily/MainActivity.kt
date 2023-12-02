package com.example.daily

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.daily.data.Recep
import com.example.daily.data.receps
import com.example.daily.ui.theme.DailyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecipeApp()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeApp() {
    Scaffold(
        topBar = {
            TopBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(receps) {
                RecepItem(
                    recipes = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun RecepItem(
    recipes: Recep,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            RecipeInformation(recipes.name, recipes.hobbies,recipes.imageResourceId )
        }

    }
}

/*
@Composable
fun RecipeImage(
    @DrawableRes recipeImg : Int,
    modifier: Modifier = Modifier
){
    Image(painter = painterResource(recipeImg),
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .clip(shapes.medium)
    )
}*/

@Composable
fun RecipeInformation(
    @StringRes recipeName: Int,
    @StringRes recipeInfo : Int,
    @DrawableRes recipeImg : Int,
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier) {
        Text(
            text = stringResource(recipeName),
            style = MaterialTheme.typography.displayMedium,
        )
        Image(painter = painterResource(recipeImg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(shapes.small)
        )
        Text(
            text =  stringResource(recipeInfo),
            style = MaterialTheme.typography.labelLarge
        )
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row() {
                Text(
                    text = stringResource(R.string.top_bar),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Preview
@Composable
fun WoofPreview() {
    DailyTheme(darkTheme = false) {
        RecipeApp()
    }
}
