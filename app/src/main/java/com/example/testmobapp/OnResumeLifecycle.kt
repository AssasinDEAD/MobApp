package com.example.testmobapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun OnResumeLifecycle(onResume: () -> Unit) {
    LaunchedEffect(Unit) {
        onResume()
    }
}
