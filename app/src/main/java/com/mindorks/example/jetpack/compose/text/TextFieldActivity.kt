package com.mindorks.example.jetpack.compose.text

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TextFieldActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                item {
                    // Divider is a composable that is used to draw a horizontal line and you can
                    // specify some color to it.
                    SimpleTextComponent("Example of Simple Text Field")
                    SimpleTextFieldComponent()
                    Divider(color = Color.Gray)

                    SimpleTextComponent("Example of Text Field for Numbers")
                    NumberTextFieldComponent()
                    Divider(color = Color.Gray)

                    SimpleTextComponent("Example of Text Field for Passwords")
                    PasswordTextFieldComponent()
                    Divider(color = Color.Gray)

                    SimpleTextComponent("Example of Simple Material Text Field")
                    SimpleMaterialTextFieldComponent()
                    Divider(color = Color.Gray)

                    SimpleTextComponent("Example of Simple Material Text Field with Placeholder")
                    PlaceholderMaterialTextFieldComponent()
                    Divider(color = Color.Gray)

                    SimpleTextComponent("Example of Simple Material Text Field with Icons")
                    IconMaterialTextFieldComponent()
                    Divider(color = Color.Gray)

                    SimpleTextComponent("Example of Simple Material Text Field with Error Handling")
                    ErrorMaterialTextFieldComponent()
                    Divider(color = Color.Gray)
                }
            }
        }
    }
}

@Composable
fun SimpleTextComponent(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@ExperimentalFoundationApi
@Composable
fun SimpleTextFieldComponent() {
    // Surface as the name suggests is used to have some UI elements over it. You can provide some
    // color, contentColor, shape, border, elevation, etc to a surface. If no contentColor is passed
    // then the surface will try to match its color with the background color.
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var text by remember { mutableStateOf(TextFieldValue("Enter text here")) }
        // BaseTextField is a composable that is used to take input. It is similar to EditText.
        // onValueChange will be called when there is a change in content of text field.
        BasicTextField(
            value = text,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onValueChange = {
                text = it
            }
        )
    }
}


@ExperimentalFoundationApi
@Composable
fun NumberTextFieldComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var text by remember { mutableStateOf(TextFieldValue("0123")) }
        // Here, only numerical keyboard will be opened
        BasicTextField(
            value = text,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            onValueChange = {
                text = it
            },
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun PasswordTextFieldComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var text by remember { mutableStateOf(TextFieldValue("9876")) }
        // This is an example of Text Field taking password as an input. It will
        // hide the password text and will show a dot.
        BasicTextField(
            value = text,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {
                text = it
            }
        )
    }
}

@Composable
fun SimpleMaterialTextFieldComponent() {
    // savedInstanceState behaves similarly to remember { mutableStateOf(...) }, but the stored value
    // will survive the activity or process recreation using the saved instance state mechanism
    // (for example it happens when the screen is rotated in the Android application)
    var text by remember { mutableStateOf("") }
    // TextField is a Material Design implementation of EditText in Compose.
    // label is the text that is displayed inside the TextField when no text is there
    TextField(
        value = text,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}

@Composable
fun PlaceholderMaterialTextFieldComponent() {
    // savedInstanceState behaves similarly to remember { mutableStateOf(...) }, but the stored value
    // will survive the activity or process recreation using the saved instance state mechanism
    // (for example it happens when the screen is rotated in the Android application)
    var text by remember { mutableStateOf("") }
    // placeholder is displayed when the TextField is focused and is empty.
    TextField(
        value = text,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        onValueChange = { text = it },
        label = { Text("Enter Name") },
        placeholder = { Text("MindOrks") }
    )
}

@Composable
fun IconMaterialTextFieldComponent() {
    // savedInstanceState behaves similarly to remember { mutableStateOf(...) }, but the stored value
    // will survive the activity or process recreation using the saved instance state mechanism
    // (for example it happens when the screen is rotated in the Android application)
    var text by remember { mutableStateOf("") }
    // You can put some icon in a TextField to make it more awesome.
    // leadingIcon will put the icon in front and trailingIcon to the end of TextField
    TextField(
        value = text,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        onValueChange = { text = it },
        label = { Text("Enter Name") },
        placeholder = { Text("MindOrks") },
        leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = null) },
        trailingIcon = { Icon(imageVector = Icons.Filled.Done, contentDescription = null) }
    )
}

@Composable
fun ErrorMaterialTextFieldComponent() {
    // savedInstanceState behaves similarly to remember { mutableStateOf(...) }, but the stored value
    // will survive the activity or process recreation using the saved instance state mechanism
    // (for example it happens when the screen is rotated in the Android application)
    var text by remember { mutableStateOf("") }
    val isValidPhoneNumber = text.count() == 10
    // isErrorValue is used to show some error while entering text.
    TextField(
        value = text,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        onValueChange = { it -> text = it },
        label = {
            val label = if (isValidPhoneNumber) "Phone Number" else "Phone Number*"
            Text(text = label)
        },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        isError = !isValidPhoneNumber
    )
}
