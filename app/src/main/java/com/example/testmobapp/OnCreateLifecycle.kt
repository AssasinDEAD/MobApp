package com.example.testmobapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun OnCreateLifecycle(onStart: () -> Unit) {
    LaunchedEffect(Unit) {
        onStart()
    }
}
