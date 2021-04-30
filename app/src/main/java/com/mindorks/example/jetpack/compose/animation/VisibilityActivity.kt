package com.mindorks.example.jetpack.compose.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
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

class VisibilityActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisibilityComponent()
        }
    }
}

//https://developer.android.com/jetpack/compose/animation#animationspec
@ExperimentalAnimationApi
@Composable
fun VisibilityComponent() {
    var visible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                visible = !visible
            },
        ) {
            Text("Visibility")
        }

        Spacer(Modifier.height(16.dp))
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically(initialOffsetY = { -40 }) +
                    expandVertically(expandFrom = Alignment.CenterVertically) +
                    fadeIn(initialAlpha = 0.5f),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            Canvas(
                modifier = Modifier
                    .size(200.dp)
            ) {
                drawRoundRect(color = Color.Red, cornerRadius = CornerRadius(80f))
            }
        }

    }
}