package com.example.composelayoutdemos.navigation.topics

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Verified
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composelayoutdemos.R
import com.example.composelayoutdemos.navigation.topics.pegasus.*

// region Home Screen

@Composable
fun PegasusHomeScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = DarkBlue)
        )
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.linearGradient(colors = listOf(Color.Transparent, Color.Black)))
        ) {
            val (topBar, tabLayout, flightCard, flightButton, checkinButton, layoutActions) = createRefs()
            TopBarArea(modifier = Modifier
                .padding(16.dp, 0.dp)
                .constrainAs(topBar) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            FlightCardArea(modifier = Modifier
                .padding(16.dp, 24.dp, 16.dp, 0.dp)
                .constrainAs(flightCard) {
                    top.linkTo(topBar.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            CampaignTabArea(modifier = Modifier
                .padding(16.dp, 0.dp)
                .constrainAs(tabLayout) {
                    bottom.linkTo(flightButton.top)

                })
            SearchFlightButton(modifier = Modifier
                .padding(16.dp, 4.dp)
                .constrainAs(flightButton) {
                    top.linkTo(tabLayout.bottom, margin = 4.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            CheckinFlightButton(modifier = Modifier
                .padding(16.dp, 8.dp)
                .constrainAs(checkinButton) {
                    top.linkTo(flightButton.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(layoutActions.top)
                })
            LayoutActionsArea(modifier = Modifier.constrainAs(layoutActions) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        }
    }
}

@Preview
@Composable
fun PegasusHomeScreenDemo() {
    PegasusHomeScreen()
}

// endregion

// region flight card

@Composable
fun FlightCardArea(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(120.dp)
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(4.dp))
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            FlightCardCornerArea()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    FlightInfoArea(modifier = Modifier, isDeparture = true)
                    Icon(
                        painter = painterResource(id = R.drawable.icon_flight_between),
                        contentDescription = null
                    )
                    FlightInfoArea(modifier = Modifier, isDeparture = false)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.background(
                            color = buttonPrimary,
                            shape = RoundedCornerShape(8.dp)
                        ).padding(8.dp, 4.dp).clickable {  },
                        text = "Biniş Kartlarım",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = textColorPrimary,
                            fontSize = 10.sp
                        )
                    )

                    Text(
                        modifier = Modifier.background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(8.dp)
                        ).padding(8.dp, 4.dp).clickable {  },
                        text = "Seyahat Detayı",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = textColorPrimary,
                            fontSize = 10.sp
                        )
                    )

                }
            }
        }
    }
}

@Composable
fun FlightCardCornerArea() {
    Box(
        modifier = Modifier
            .width(24.dp)
            .background(color = flightCardAccentColor)
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_plane_small),
            contentDescription = null,
            tint = buttonPrimary
        )
    }
}

@Composable
fun FlightInfoArea(modifier: Modifier = Modifier, isDeparture: Boolean = true) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = if (isDeparture) Alignment.Start else Alignment.End
    ) {
        Text(text = "24.03.2020")
        Text(text = "Istanbul - SAW")
        Text(text = "07:15")
    }
}

@Preview
@Composable
fun FlightCardAreaDemo() {
    FlightCardArea()
}

// endregion

// region Topbar

@Composable
fun NotificationIcon(modifier: Modifier = Modifier, newNotification: Boolean = true) {
    Box(
        modifier = Modifier
            .padding(8.dp, 0.dp)
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
fun LoginArea(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(8.dp, 0.dp)
            .background(color = Color.White.copy(alpha = 0.8F), shape = RoundedCornerShape(4.dp))
    ) {
        Row(
            modifier = Modifier.padding(4.dp, 0.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = textLogin,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(4.dp, 0.dp)
            )
            Icon(
                modifier = Modifier
                    .padding(4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(4.dp)),
                imageVector = Icons.Default.Person,
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
fun LoginAreaDemo() {
    LoginArea()
}

@Composable
fun MainLogoArea(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_pegasus),
        contentDescription = null,
        alignment = Alignment.Center
    )
}

@Preview
@Composable
fun MainLogoAreaDemo() {
    MainLogoArea()
}

@Composable
fun TopBarArea(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
        MainLogoArea(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(8.dp, 0.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            LoginArea()
            NotificationIcon()
        }
    }
}

@Preview
@Composable
fun TopBarAreaDemo() {
    TopBarArea()
}

// endregion

// region tablayout

@Composable
fun CampaignTabIndicator(selected: Boolean) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .height(12.dp)
            .width(12.dp)
            .clip(CircleShape)
            .background(color = if (selected) buttonPrimary else Color.Gray)
    )
}

@Preview
@Composable
fun CampaignTabIndicatorDemo() {
    CampaignTabIndicator(true)
}

@Composable
fun CampaignTabArea(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        listOf<Boolean>(true, false, false).map {
            CampaignTabIndicator(selected = it)
        }
    }
}

@Preview
@Composable
fun CampaignTabAreaDemo() {
    CampaignTabArea()
}

// endregion

//region Buttons
@Composable
fun MainScreenButton(modifier: Modifier = Modifier, backgroundColor: Color, text: String) {
    Button(
        modifier = modifier,
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

@Composable
fun SearchFlightButton(modifier: Modifier = Modifier) {
    MainScreenButton(modifier = modifier, backgroundColor = buttonPrimary, text = textSearchFlight)
}

@Composable
fun CheckinFlightButton(modifier: Modifier = Modifier) {
    MainScreenButton(modifier = modifier, backgroundColor = Color.White, text = textCheckinFlight)
}

@Preview
@Composable
fun CheckinFlightButtonDemo() {
    CheckinFlightButton()
}

@Preview
@Composable
fun SearchFlightButtonDemo() {
    SearchFlightButton()
}


// endregion

// region Button Rows

@Composable
fun MainScreenButton(modifier: Modifier = Modifier, button: ButtonItem) {
    Box(modifier = modifier.padding(8.dp), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .height(60.dp)
                .width(IntrinsicSize.Max)
                .wrapContentWidth(),
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
fun LayoutActionsArea(buttonList: List<ButtonItem>, topRow: Boolean) {
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
            MainScreenButton(Modifier.weight(1f), button = button)
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

@Composable
fun LayoutActionsArea(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        LayoutActionsArea(buttonListTopRow, true)
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
        LayoutActionsArea(buttonListBottomRow, false)
    }
}

@Preview
@Composable
fun ButtonRowDemo() {
    LayoutActionsArea()
}

// endregion