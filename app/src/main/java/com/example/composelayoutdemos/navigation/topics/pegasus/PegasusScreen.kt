package com.example.composelayoutdemos.navigation.topics

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelayoutdemos.navigation.topics.pegasus.buttonPrimary
import com.example.composelayoutdemos.navigation.topics.pegasus.textCheckinFlight
import com.example.composelayoutdemos.navigation.topics.pegasus.textColorPrimary
import com.example.composelayoutdemos.navigation.topics.pegasus.textSearchFlight

@Composable
fun PegasusHomeScreen() {

}

// region Topbar

// endregion

//region Buttons
@Composable
fun MainScreenButton(backgroundColor: Color, text: String) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 12.dp),
            text = text,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            style = TextStyle(color = textColorPrimary, fontSize = 14.sp, lineHeight = 24.sp)
        )
    }
}

@Preview
@Composable
fun CheckinFlightButtonDemo() {
    MainScreenButton(backgroundColor = Color.White, text = textCheckinFlight)
}

@Preview
@Composable
fun SearchFlightButton() {
    MainScreenButton(backgroundColor = buttonPrimary, text = textSearchFlight)
}



// endregion

// region Button Rows

// endregion