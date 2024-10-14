package com.example.testmobapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun OnStopLifecycle(onStop: () -> Unit) {
    LaunchedEffect(Unit) {
        onStop()
    }
}
