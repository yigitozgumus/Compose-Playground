package com.example.composelayoutdemos.navigation.topics

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelayoutdemos.R
import com.example.composelayoutdemos.navigation.topics.pegasus.*

@Composable
fun PegasusHomeScreen() {
}

@Preview
@Composable
fun PegasusHomeScreenDemo() {
    PegasusHomeScreen()
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

@Composable
fun MainScreenButton(button: ButtonItem) {
    Box(modifier = Modifier.padding(8.dp)){
        Column( modifier = Modifier
            .width(80.dp)
            .height(60.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = button.icon),contentDescription = null)
            Text(text = button.description, style= TextStyle(color = Color.White, fontSize = 12.sp), textAlign = TextAlign.Center)
        }

    }
}

@Preview
@Composable
fun BolBolButtonDemo() {
    MainScreenButton(button = ButtonItem(R.drawable.icons_home_bol_bol, textBolbol) )
}

@Composable
fun ButtonRow(buttonList: List<ButtonItem>){
    Row(modifier = Modifier
        .height(IntrinsicSize.Min)
        .fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween) {
        buttonList.forEachIndexed { index, button ->
            MainScreenButton(button = button)
            if (index != buttonList.lastIndex) {
                Spacer(modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .background(color = Color.White))
            }
        }
    }
}

@Preview
@Composable
fun ButtonRowDemo() {
    Column(modifier = Modifier.fillMaxWidth()) {
        ButtonRow(buttonListTopRow)
        Spacer(modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(color = Color.White))
        ButtonRow(buttonListBottomRow) }
}

// endregion