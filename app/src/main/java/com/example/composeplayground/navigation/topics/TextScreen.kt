package com.example.composeplayground.navigation.topics

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.theme.Blue100
import com.example.composeplayground.ui.theme.ComposeLayoutDemosTheme

@Composable
fun TextScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .scrollable(
                enabled = true,
                orientation = Orientation.Vertical,
                state = scrollState
            )
    ) {
        TextScreenDemoItem {
            Text(text = "Compose Demo")
        }
        TextScreenDemoItem {
            Text("Text with cursive font", style = TextStyle(fontFamily = FontFamily.Cursive))
        }
        TextScreenDemoItem {
            Text(
                text = "Text with linethrough",
                style = TextStyle(textDecoration = TextDecoration.LineThrough)
            )
        }
        TextScreenDemoItem {
            Text(
                text = "Text with underline",
                style = TextStyle(textDecoration = TextDecoration.Underline)
            )
        }
        TextScreenDemoItem {
            Text(
                text = "Text with underline, linethrough and bold.",
                style = TextStyle(
                    textDecoration = TextDecoration.combine(
                        listOf(
                            TextDecoration.LineThrough,
                            TextDecoration.Underline
                        )
                    ),
                    fontWeight = FontWeight.Bold
                )
            )
        }
        TextScreenDemoItem{
            Box(modifier = Modifier.background(color = Blue100)) {
                Text("Surface shape Demo")
            }
        }
    }
}

//region Demo Component

@Composable
fun TextScreenDemoItem(
    modifier: Modifier = Modifier.fillMaxWidth(),
    content: @Composable () -> Unit
) {
    ComposeLayoutDemosTheme {
        Surface(modifier = modifier
            .padding(16.dp)
            .border(1.dp, Color.Blue)
            .padding(16.dp)) {
            content()
        }
    }
}

@Preview
@Composable
fun demoTextScreen() {
    TextScreenDemoItem {
        Text(
            modifier = Modifier.padding(16.dp, 8.dp),
            text = "Compose Demo", style = MaterialTheme.typography.body1.copy(
                background = MaterialTheme.colors.background
            )
        )
    }
}

//endregion