package com.example.googleauthapp.presentation.screen.login

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.googleauthapp.ui.theme.topAppBarBackgroundColor
import com.example.googleauthapp.ui.theme.topAppBarContentColor

@Composable
fun LoginTopBar() {
    // TopAppBar composable function
    TopAppBar(
        title = {
            Text(
                text = "Sign in",
                color = MaterialTheme.colors.topAppBarContentColor // extension function
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
@Preview
fun LoginTopBarPreview() {
    LoginTopBar()
}