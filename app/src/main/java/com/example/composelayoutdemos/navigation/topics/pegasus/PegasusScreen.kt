package com.example.composelayoutdemos.navigation.topics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Verified
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelayoutdemos.navigation.topics.pegasus.ButtonItem
import com.example.composelayoutdemos.navigation.topics.pegasus.buttonListBottomRow
import com.example.composelayoutdemos.navigation.topics.pegasus.buttonListTopRow
import com.example.composelayoutdemos.navigation.topics.pegasus.buttonPrimary
import com.example.composelayoutdemos.navigation.topics.pegasus.textBolbol
import com.example.composelayoutdemos.navigation.topics.pegasus.textCheckinFlight
import com.example.composelayoutdemos.navigation.topics.pegasus.textColorPrimary
import com.example.composelayoutdemos.navigation.topics.pegasus.textLogin
import com.example.composelayoutdemos.navigation.topics.pegasus.textSearchFlight

@Composable
fun PegasusHomeScreen() {

}

@Preview
@Composable
fun PegasusHomeScreenDemo() {
    PegasusHomeScreen()
}

// region Topbar

@Composable
fun NotificationIcon(newNotification: Boolean = true) {
    Box(
        modifier = Modifier
            .width(32.dp)
            .height(32.dp)
            .background(color = buttonPrimary, shape = RoundedCornerShape(4.dp))
    ) {
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.padding(4.dp)
        )
        // TODO: add new notification icon
    }
}

@Preview
@Composable
fun NotificationIconDemo() {
    NotificationIcon()
}

@Composable
fun loginArea() {
    Box(modifier = Modifier.background(color = Color.White.copy(alpha = 0.8F))) {
        Row(modifier = Modifier.padding(4.dp)) {
            Text(text = textLogin)
            Icon(
                modifier = Modifier.padding(4.dp),
                imageVector = Icons.Default.Person,
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun loginAreaDemo() {
    loginArea()
}

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
fun SearchFlightButtonDemo() {
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
            Icon(
                imageVector = button.icon,
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = button.description,
                style = TextStyle(color = Color.White, fontSize = 12.sp),
                textAlign = TextAlign.Center
            )
        }

    }
}

@Preview
@Composable
fun BolBolButtonDemo() {
    MainScreenButton(button = ButtonItem(Icons.Default.Verified, textBolbol))
}

@Composable
fun ButtonRow(buttonList: List<ButtonItem>, topRow: Boolean){
    val gradientBrush = if (topRow) {
        Brush.verticalGradient(listOf(Color.Transparent, Color.White))
    } else {
        Brush.verticalGradient(listOf(Color.White, Color.Transparent))
    }
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        buttonList.forEachIndexed { index, button ->
            MainScreenButton(button = button)
            if (index != buttonList.lastIndex) {
                Spacer(
                    modifier = Modifier
                        .width(1.dp)
                        .fillMaxHeight()
                        .background(gradientBrush)
                )
            }
        }
    }
}

@Preview
@Composable
fun ButtonRowDemo() {
    Column(modifier = Modifier.fillMaxWidth()) {
        ButtonRow(buttonListTopRow, true)
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listOf(Color.Transparent, Color.White, Color.Transparent)
                    )
                )
        )
        ButtonRow(buttonListBottomRow, false) }
}

// endregion