package com.mindorks.example.jetpack.compose.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class ContentSizeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContentSizeComponent()
        }
    }
}

@Composable
fun ContentSizeComponent() {
    var size by remember { mutableStateOf(200) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                if (size < 30) {
                    size += 200
                } else {
                    size -= 30
                }
            }
        ) {
            Text("ContentSize")
        }
        Spacer(Modifier.height(16.dp))
        Canvas(
            modifier = Modifier
                .size(size.dp)
                .animateContentSize()
        ) {
            drawRoundRect(color = Color.Red, cornerRadius = CornerRadius(size * 0.3f))
        }
    }
}