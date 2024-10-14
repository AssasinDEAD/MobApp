package com.example.testmobapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CounterScreen(counterValue: Int, onValueChange: (Int) -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Счётчик: $counterValue")
        Button(onClick = { onValueChange(counterValue + 1) }) {
            Text("+")
        }
    }
}
