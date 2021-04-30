package com.mindorks.example.jetpack.compose.layout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindorks.example.jetpack.compose.R

class StackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StackComponent()
        }
    }
}

@Composable
fun StackComponent() {
    // Stack is used to place one element over the other. For example, here
    // the text is placed over the image.
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(painter = painterResource(R.drawable.mindorks_cover), contentDescription = null)
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            text = "I am a text over the Image",
            fontSize = 16.sp,
            color = Color.Red
        )
    }
}

// NOTE: Stack is deprecated now. So, instead of Stack, you can use Box