package com.example.testmobapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testmobapp.ui.theme.TestMobAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestMobAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var showTimerScreen by remember { mutableStateOf(true) }
    var counterValue by remember { mutableStateOf(0) }

    // Состояние таймера и активности
    var timeLeft by remember { mutableStateOf(60) }
    var isActive by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = { showTimerScreen = true }) {
            Text("Перейти к таймеру")
        }

        Button(onClick = { showTimerScreen = false }) {
            Text("Перейти к счётчику")
        }

        if (showTimerScreen) {
            TimerScreen(
                onBackPressed = { showTimerScreen = false },
                timeLeft = timeLeft,
                isActive = isActive,
                onTimeChange = { newTime, active ->
                    timeLeft = newTime
                    isActive = active
                }
            )
        } else {
            CounterScreen(counterValue = counterValue, onValueChange = { counterValue = it })
        }
    }
}
