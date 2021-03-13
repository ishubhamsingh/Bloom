package com.ishubhamsingh.androiddevchallenge.bloom.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ishubhamsingh.androiddevchallenge.bloom.R
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.MyTheme
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.gray
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.green300
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.pink900
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.white

@Composable
fun WelcomePage() {
    WelcomeBackground()
    WelcomeContent()
}

@Composable
fun WelcomeBackground() {
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(), color = MaterialTheme.colors.primary
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_welcome_bg),
            contentDescription = "bloom_bg",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun WelcomeContent() {
    Column(
        modifier = Modifier.padding(top = 72.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_welcome_illos),
            contentDescription = "bloom_leaf",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 88.dp),
            alignment = Alignment.CenterStart
        )

        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "bloom_logo",
            modifier = Modifier.padding(top = 48.dp)
        )

        Text(
            text = "Beautiful home garden solutions",
            style = MaterialTheme.typography.subtitle1,
            color = if (MaterialTheme.colors.isLight) gray else white,
            modifier = Modifier.paddingFromBaseline(top = 32.dp, bottom = 40.dp)
        )

        Button(
            onClick = { /*TODO*/ }, shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(start = 16.dp, end = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = if (MaterialTheme.colors.isLight) pink900 else green300),
        ) {
            Text(
                text = "Create account",
                style = MaterialTheme.typography.button,
                color = if (MaterialTheme.colors.isLight) white else gray
            )
        }

        TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 24.dp)) {
            Text(
                text = "Log in",
                style = MaterialTheme.typography.button,
                color = if (MaterialTheme.colors.isLight) pink900 else white
            )
        }
    }
}

@Preview("Welcome Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeLightPreview() {
    MyTheme {
        WelcomePage()
    }
}

@Preview("Welcome Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeDarkPreview() {
    MyTheme(darkTheme = true) {
        WelcomePage()
    }
}