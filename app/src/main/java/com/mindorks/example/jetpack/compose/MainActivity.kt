package com.mindorks.example.jetpack.compose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mindorks.example.jetpack.compose.animation.*
import com.mindorks.example.jetpack.compose.button.MaterialButtonActivity
import com.mindorks.example.jetpack.compose.card.CardExampleActivity
import com.mindorks.example.jetpack.compose.clickable.ClickableExampleActivity
import com.mindorks.example.jetpack.compose.customview.CustomViewActivity
import com.mindorks.example.jetpack.compose.dialog.AlertDialogActivity
import com.mindorks.example.jetpack.compose.dialog.SingleChoiceDialogActivity
import com.mindorks.example.jetpack.compose.image.ImageActivity
import com.mindorks.example.jetpack.compose.layout.*
import com.mindorks.example.jetpack.compose.materialdesign.*
import com.mindorks.example.jetpack.compose.preview.PreviewParameterActivity
import com.mindorks.example.jetpack.compose.preview.SimplePreviewActivity
import com.mindorks.example.jetpack.compose.text.SimpleTextActivity
import com.mindorks.example.jetpack.compose.text.TextFieldActivity
import com.mindorks.example.jetpack.compose.text.TextStylingActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            LazyColumn {
                item {
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, SimpleTextActivity::class.java),
                        buttonText = "Simple Text"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, TextStylingActivity::class.java),
                        buttonText = "Text Styling"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, TextFieldActivity::class.java),
                        buttonText = "Text Field (EditText)"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, SimplePreviewActivity::class.java),
                        buttonText = "Simple Preview"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, PreviewParameterActivity::class.java),
                        buttonText = "Preview Parameter"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, ColumnActivity::class.java),
                        buttonText = "Simple Column"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, ScrollableColumnActivity::class.java),
                        buttonText = "Scrollable Column"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, LazyColumnActivity::class.java),
                        buttonText = "Lazy Column"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, RowActivity::class.java),
                        buttonText = "Row"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, ScrollableRowActivity::class.java),
                        buttonText = "Scrollable Row"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, LazyRowActivity::class.java),
                        buttonText = "Lazy Row"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, BoxActivity::class.java),
                        buttonText = "Box"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, StackActivity::class.java),
                        buttonText = "Stack (Deprecated)"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, ConstraintLayoutActivity::class.java),
                        buttonText = "Constraint Layout"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, MaterialButtonActivity::class.java),
                        buttonText = "Button"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, CardExampleActivity::class.java),
                        buttonText = "Card"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, ClickableExampleActivity::class.java),
                        buttonText = "Clickable"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, ImageActivity::class.java),
                        buttonText = "Image"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, AlertDialogActivity::class.java),
                        buttonText = "Alert Dialog"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, SingleChoiceDialogActivity::class.java),
                        buttonText = "Single Choice Dialog"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, MaterialAppBarActivity::class.java),
                        buttonText = "Material App Bar"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, MaterialBottomNavigationActivity::class.java),
                        buttonText = "Material Bottom Navigation"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, MaterialCheckBoxActivity::class.java),
                        buttonText = "Material Checkbox"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, MaterialProgressActivity::class.java),
                        buttonText = "Material Progress Bar"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, MaterialRadioButtonActivity::class.java),
                        buttonText = "Material Radio Button"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, MaterialSliderActivity::class.java),
                        buttonText = "Material Slider"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, MaterialSnackbarActivity::class.java),
                        buttonText = "Material Snackbar"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, MaterialSwitchActivity::class.java),
                        buttonText = "Material Switch"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, CustomViewActivity::class.java),
                        buttonText = "Custom View"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, CrossFadeAnimationActivity::class.java),
                        buttonText = "Crossfade Animation"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, ShapeRotationActivity::class.java),
                        buttonText = "Shape Rotation Animation"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, ShakeActivity::class.java),
                        buttonText = "Shake Animation"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, VisibilityActivity::class.java),
                        buttonText = "Visibility Animation"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, ContentSizeActivity()::class.java),
                        buttonText = "ContentSize Animation"
                    )
                    Divider(color = Color.Black)
                    ButtonComponent(
                        context = context,
                        intent = Intent(context, TransitionActivity()::class.java),
                        buttonText = "Transition Animation"
                    )
                }

            }
        }
    }
}

@Composable
fun ButtonComponent(context: Context, intent: Intent, buttonText: String) {
    Button(
        onClick = {
            context.startActivity(intent)
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            text = buttonText,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}