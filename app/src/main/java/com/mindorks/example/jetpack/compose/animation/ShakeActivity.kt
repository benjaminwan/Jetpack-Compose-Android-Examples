package com.mindorks.example.jetpack.compose.animation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.*
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

class ShakeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShakeComponent()
        }
    }
}

@Composable
fun ShakeComponent() {
    val isOpaque = remember { mutableStateOf(value = true) }
    val result = remember { mutableStateOf("") }
    val isEnabled = remember { mutableStateOf(true) }

    val alpha: Float by animateFloatAsState(
        targetValue = if (isOpaque.value) 1f else 0.1f,

        // keyframes animation is based on the snapshot values
        // and specified at different timestamps
        animationSpec = keyframes {
            durationMillis = 300
            0f at 0
            -10f at 25 with LinearOutSlowInEasing //自己翻译吧
            0f at 50
            10f at 75
            0f at 100
            -8f at 125
            0f at 150
            8f at 175
            0f at 200
            -5f at 225
            0f at 250
            5f at 275
            0f at 300
        },
        // animation finished listener
        finishedListener = {
            result.value = "Finished at alpha $it"
            isEnabled.value = true
        }
    )

    /*var shake by remember { mutableStateOf(0.dp) }
    val shakeOffset = animateDpAsState(
        targetValue = 0.dp, animationSpec = keyframes {
            durationMillis = 300
            0.dp at 0 //如果觉得这个动画太硬朗，在这里是可以制定插值函数的。比如下面的
            (-10).dp at 25 with LinearOutSlowInEasing //自己翻译吧
            0.dp at 50
            10.dp at 75
            0.dp at 100
            (-8).dp at 125
            0.dp at 150
            8.dp at 175
            0.dp at 200
            (-5).dp at 225
            0.dp at 250
            5.dp at 275
            0.dp at 300
        }
    ) {
        shake.value
    }*/
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                isOpaque.value = !isOpaque.value
                isEnabled.value = false
            },
            enabled = isEnabled.value
        ) {
            Text("Shake")
        }

        Spacer(Modifier.height(16.dp))

        Canvas(
            modifier = Modifier
                .size(200.dp)
                .offset(alpha.dp, alpha.dp)
        ) {
            drawRoundRect(color = Color.Red, cornerRadius = CornerRadius(80f))
        }
    }
}