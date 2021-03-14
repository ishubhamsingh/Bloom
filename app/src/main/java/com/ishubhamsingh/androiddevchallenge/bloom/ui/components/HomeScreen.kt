package com.ishubhamsingh.androiddevchallenge.bloom.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.transform.RoundedCornersTransformation
import com.ishubhamsingh.androiddevchallenge.bloom.ui.models.DesignItem
import com.ishubhamsingh.androiddevchallenge.bloom.ui.models.Theme
import com.ishubhamsingh.androiddevchallenge.bloom.ui.models.getDesignData
import com.ishubhamsingh.androiddevchallenge.bloom.ui.models.getThemeData
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.MyTheme
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.gray
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.green900
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.pink100
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.white
import dev.chrisbanes.accompanist.coil.CoilImage
import java.util.*
import androidx.compose.runtime.getValue

@Composable
fun HomePage() {
    Scaffold(
        bottomBar = { HomeBottomNav() },
        backgroundColor = MaterialTheme.colors.background
    ) {
        HomeContent()
    }
}

@Composable
fun HomeBottomNav() {
    BottomNavigation(backgroundColor = if (MaterialTheme.colors.isLight) pink100 else green900, modifier = Modifier.defaultMinSize(minHeight = 56.dp)) {
        BottomNavigationItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "home", Modifier.size(24.dp)) },
            label = { Text(text = "Home", style = MaterialTheme.typography.caption) },
            selectedContentColor = if (MaterialTheme.colors.isLight) gray else white,
            unselectedContentColor = if (MaterialTheme.colors.isLight) gray.copy(alpha = 0.5f) else white.copy(
                alpha = 0.5f
            ),
        )

        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "favourites",
                    Modifier.size(24.dp)
                )
            },
            label = { Text(text = "Favourites", style = MaterialTheme.typography.caption) },
            selectedContentColor = if (MaterialTheme.colors.isLight) gray else white,
            unselectedContentColor = if (MaterialTheme.colors.isLight) gray.copy(alpha = 0.5f) else white.copy(
                alpha = 0.5f
            ),
        )

        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "profile",
                    Modifier.size(24.dp)
                )
            },
            label = { Text(text = "Profile", style = MaterialTheme.typography.caption) },
            selectedContentColor = if (MaterialTheme.colors.isLight) gray else white,
            unselectedContentColor = if (MaterialTheme.colors.isLight) gray.copy(alpha = 0.5f) else white.copy(
                alpha = 0.5f
            ),
        )

        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "cart", Modifier.size(24.dp)) },
            label = { Text(text = "Cart", style = MaterialTheme.typography.caption) },
            selectedContentColor = if (MaterialTheme.colors.isLight) gray else white,
            unselectedContentColor = if (MaterialTheme.colors.isLight) gray.copy(alpha = 0.5f) else white.copy(
                alpha = 0.5f
            ),
        )

    }
}

@Composable
fun HomeContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 16.dp)
    ) {
        HomeSearch()
        HomeCardsRow()
        HomeCardColumn()
    }
}

@Composable
fun HomeSearch() {
    OutlinedTextField(
        value = "",
        onValueChange = { /*TODO*/ },
        placeholder = { Text(text = "Search", style = MaterialTheme.typography.body1) },
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxWidth()
            .defaultMinSize(minHeight = 56.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "search",
                Modifier.size(18.dp)
            )
        })
}

@Composable
fun HomeCardsRow() {
    Column {
        Text(
            text = "Browse themes",
            style = MaterialTheme.typography.h1,
            color = if (MaterialTheme.colors.isLight) gray else white,
            modifier = Modifier.paddingFromBaseline(top = 32.dp),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(136.dp),
            contentPadding = PaddingValues(2.dp)
        ) {
            itemsIndexed(items = getThemeData()) { index, theme ->
                key(index) {
                    CardRowItem(theme = theme)
                }
            }
        }
    }
}

@Composable
fun CardRowItem(theme: Theme) {
    Card(
        modifier = Modifier
            .size(136.dp)
            .clickable { },
        shape = MaterialTheme.shapes.small,
        elevation = 1.dp,
        backgroundColor = MaterialTheme.colors.surface

    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            CoilImage(
                data = theme.imageUrl,
                contentDescription = "theme_item_${theme.title.toLowerCase(Locale.ROOT)}",
                fadeIn = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp),
                contentScale = ContentScale.Crop,
                loading = {
                    Box(Modifier.height(96.dp)) {
                        CircularProgressIndicator(
                            Modifier.align(Alignment.Center),
                            color = if (MaterialTheme.colors.isLight) pink100 else green900
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = theme.title,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

@Composable
fun HomeCardColumn() {
    Column {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(top = 40.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Design your home garden", style = MaterialTheme.typography.h1, color = MaterialTheme.colors.onBackground)
            Icon(imageVector = Icons.Default.FilterList, contentDescription = "filter", Modifier.size(24.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(getDesignData()){ index, designItem ->
                key(index) {
                    CardColumnItem(designItem = designItem)
                }
            }
        }
    }
}

@Composable
fun CardColumnItem(designItem: DesignItem) {
    val checkedState = remember { mutableStateOf(designItem.isChecked) }
    Row(
        Modifier
            .height(64.dp)
            .fillMaxWidth()) {
        CoilImage(
            data = designItem.imgUrl,
            contentDescription = "design_item_${designItem.title.toLowerCase(Locale.ROOT)}",
            fadeIn = true,
            modifier = Modifier
                .size(64.dp),
            contentScale = ContentScale.Crop,
            loading = {
                Box(Modifier.size(64.dp)) {
                    CircularProgressIndicator(
                        Modifier.align(Alignment.Center),
                        color = if (MaterialTheme.colors.isLight) pink100 else green900
                    )
                }
            },
            requestBuilder = {
                transformations(RoundedCornersTransformation(16f))
            }
        )

        Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxHeight(), horizontalAlignment = Alignment.End) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Column() {
                    Text(text = designItem.title, style = MaterialTheme.typography.h2, color = MaterialTheme.colors.onBackground, modifier = Modifier.paddingFromBaseline(top = 24.dp))
                    Text(text = "This is a description", style= MaterialTheme.typography.body1, color = MaterialTheme.colors.onBackground)
                }

                Checkbox(checked = checkedState.value, onCheckedChange = { checkedState.value = !checkedState.value}, modifier = Modifier.size(24.dp))
            }

            Divider(modifier = Modifier.padding(start = 8.dp))

        }
    }
}

@Preview("Card Row Item Light")
@Composable
fun CardRowItemLight() {
    MyTheme {
        CardRowItem(getThemeData()[0])
    }
}

@Preview("Card Row Item Dark")
@Composable
fun CardRowItemDark() {
    MyTheme(darkTheme = true) {
        CardRowItem(getThemeData()[0])
    }
}

@Preview("Home Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeLightPreview() {
    MyTheme {
        HomePage()
    }
}

@Preview("Home Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomenDarkPreview() {
    MyTheme(darkTheme = true) {
        HomePage()
    }
}