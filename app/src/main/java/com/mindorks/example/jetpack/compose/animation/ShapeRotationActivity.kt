package com.mindorks.example.jetpack.compose.animation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp

class ShapeRotationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RotatingComponent()
        }
    }
}

private sealed class RotateState(val rotation: Float) {
    operator fun not() = if (this is Initial) Final else Initial

    object Initial : RotateState(0f)
    object Final : RotateState(180f)
}

@Composable
fun RotatingComponent() {
    var state: RotateState by remember { mutableStateOf(RotateState.Initial) }
    val degree = animateFloatAsState(state.rotation)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                state = !state
            }
        ) {
            Text("Rotate")
        }
        Spacer(Modifier.height(16.dp))
        // Here we are drawing a square over a Canvas and then we are rotating the canvas
        Canvas(modifier = Modifier.size(200.dp)) {
            rotate(degree.value) {
                drawRoundRect(color = Color.Red,cornerRadius = CornerRadius(80f))
            }
        }

    }
}