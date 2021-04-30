package com.mindorks.example.jetpack.compose.image

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mindorks.example.jetpack.compose.R

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                item {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        text = "This is a Simple Image"
                    )
                    SimpleImageComponent()
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        text = "This is an image with rounded corners"
                    )
                    RoundedImageComponent()
                }
            }
        }
    }
}

@Composable
fun SimpleImageComponent() {
    // Image is a composable that is used to display some image.
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.mindorks_cover), contentDescription = null)
    }
}

@Composable
fun RoundedImageComponent() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        // contentScale is used to find the scaling aspect ratio
        Image(
            painter = painterResource(id = R.drawable.mindorks_cover),
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Fit,
            contentDescription = null
        )
    }
}