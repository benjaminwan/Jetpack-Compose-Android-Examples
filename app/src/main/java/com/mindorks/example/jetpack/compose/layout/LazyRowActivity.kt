package com.mindorks.example.jetpack.compose.layout

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindorks.example.jetpack.compose.data.Blog
import com.mindorks.example.jetpack.compose.data.getBlogList

class LazyRowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyRowScrollableComponent(blogList = getBlogList())
        }
    }
}

@Composable
fun LazyRowScrollableComponent(blogList: List<Blog>) {
    // As the name suggests, LazyRowFor will load only that elements that are currently
    // visible on the screen. When you scroll horizontally then other elements of the row will be
    // loaded(kind of similar to RecyclerView).
    val context = LocalContext.current
    LazyRow(modifier = Modifier.fillMaxHeight()) {
        items(items = blogList) { blog ->
            // Card is a Composable that is used to give the layout of a CardView in Compose.
            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.fillParentMaxWidth().padding(16.dp).clickable(onClick = {
                    Toast.makeText(context, "Author: ${blog.author}", Toast.LENGTH_SHORT).show()
                }),
                backgroundColor = Color(0xFFFFA867.toInt())
            ) {
                Text(
                    blog.name, style = TextStyle(
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    ), modifier = Modifier.padding(16.dp)
                )
            }
        }

    }
}