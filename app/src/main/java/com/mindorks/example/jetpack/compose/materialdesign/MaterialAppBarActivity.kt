package com.mindorks.example.jetpack.compose.materialdesign

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MaterialAppBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                SimpleTextComponent(text = "Bottom Appbar")
                BottomAppBarComponent()
                SimpleTextComponent(text = "Top Appbar")
                TopAppBarComponent()
            }
        }
    }
}

@Composable
fun BottomAppBarComponent() {
    // BottomAppBar is a composable that is placed at the bottom of the screen and it contains
    // some actions that are related to the current screen.
    BottomAppBar(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        // Here, this is a RowScope and due this, all the children will be placed
        // horizontally.

        // IconButton consists of an Icon that is behaving like a button. You can think
        // of this as a clickable image.
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        }
        // Spacer is used to provide some space in between UI elements
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
        }
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
        }
    }
}

@Composable
fun TopAppBarComponent() {
    // TopAppBar is generally used to have the app name or icon for navigation drawer.
    // Basically it is the AppBar that we use in Android.
    TopAppBar(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        title = { Text("App Name") },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
            }
        },
        actions = {
            // Here, this is a RowScope and due to this, all children will be placed
            // horizontally.
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
            }
        }
    )
}