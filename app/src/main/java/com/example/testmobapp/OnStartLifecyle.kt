package com.example.testmobapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun OnStartLifecycle(onStart: () -> Unit) {
    LaunchedEffect(Unit) {
        onStart()
    }
}
