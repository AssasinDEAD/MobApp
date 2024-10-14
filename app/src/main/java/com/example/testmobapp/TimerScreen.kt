package com.example.testmobapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun TimerScreen(onBackPressed: () -> Unit, timeLeft: Int, isActive: Boolean, onTimeChange: (Int, Boolean) -> Unit) {
    var localTimeLeft by remember { mutableStateOf(timeLeft) }
    var localIsActive by remember { mutableStateOf(isActive) }

    OnCreateLifecycle {
        localIsActive = true
        onTimeChange(localTimeLeft, localIsActive)
    }

    OnPauseLifecycle {
        localIsActive = false
        onTimeChange(localTimeLeft, localIsActive)
    }

    OnResumeLifecycle {
        localIsActive = true
        onTimeChange(localTimeLeft, localIsActive)
    }

    LaunchedEffect(localIsActive) {
        if (localIsActive) {
            while (localTimeLeft > 0) {
                delay(1000)
                localTimeLeft--
                onTimeChange(localTimeLeft, true)
            }
        }
    }

    LaunchedEffect(timeLeft) {
        localTimeLeft = timeLeft
    }

    DisposableEffect(Unit) {
        onDispose {
            onTimeChange(localTimeLeft, false) // Останавливаем таймер при уничтожении
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Осталось времени: $localTimeLeft секунд")
        Button(onClick = onBackPressed) {
            Text("Назад")
        }
    }
}
