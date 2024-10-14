package com.example.testmobapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun OnPauseLifecycle(onPause: () -> Unit) {
    LaunchedEffect(Unit) {
        onPause()
    }
}
