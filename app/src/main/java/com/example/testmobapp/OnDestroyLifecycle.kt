package com.example.testmobapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun OnDestroyLifecycle(onDestroy: () -> Unit) {
    LaunchedEffect(Unit) {
        onDestroy()
    }
}
