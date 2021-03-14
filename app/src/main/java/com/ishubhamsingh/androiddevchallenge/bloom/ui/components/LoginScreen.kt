package com.ishubhamsingh.androiddevchallenge.bloom.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.MyTheme
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.gray
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.green300
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.pink900
import com.ishubhamsingh.androiddevchallenge.bloom.ui.theme.white

@Composable
fun LoginPage() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), color = MaterialTheme.colors.background
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login with email",
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.paddingFromBaseline(top = 184.dp)
            )

            OutlinedTextField(value = "",
                onValueChange = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
                    .defaultMinSize(minHeight = 56.dp),
                placeholder = {
                    Text(text = "Email address", style = MaterialTheme.typography.body1)
                })

            OutlinedTextField(value = "", onValueChange = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .defaultMinSize(minHeight = 56.dp), placeholder = {
                Text(text = "Password (8+ characters)", style = MaterialTheme.typography.body1)
            })

            Text(
                buildAnnotatedString {
                    append("By clicking below, you agree to our ")

                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("Terms of Use")
                    }
                    append(" and consent to our ")

                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("Privacy Policy")
                    }
                    append(".")
                },
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .paddingFromBaseline(top = 24.dp),
                maxLines = 2,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /*TODO*/ }, shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(start = 16.dp, end = 16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = if (MaterialTheme.colors.isLight) pink900 else green300),
            ) {
                Text(
                    text = "Log in",
                    style = MaterialTheme.typography.button,
                    color = if (MaterialTheme.colors.isLight) white else gray
                )
            }
        }

    }
}

@Preview("Login Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginLightPreview() {
    MyTheme {
        LoginPage()
    }
}

@Preview("Login Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginDarkPreview() {
    MyTheme(darkTheme = true) {
        LoginPage()
    }
}