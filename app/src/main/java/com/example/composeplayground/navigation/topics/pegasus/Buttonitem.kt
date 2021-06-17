package com.example.composeplayground.navigation.topics.pegasus

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.AirlineSeatFlatAngled
import androidx.compose.material.icons.filled.AirplaneTicket
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Backpack
import androidx.compose.material.icons.filled.HdrPlus
import androidx.compose.material.icons.filled.More
import androidx.compose.material.icons.filled.Verified
import androidx.compose.ui.graphics.vector.ImageVector

data class ButtonItem(val icon: ImageVector, val description: String)

val buttonListTopRow = listOf<ButtonItem>(
    ButtonItem(Icons.Default.Verified, textBolbol),
    ButtonItem(Icons.Default.AirlineSeatFlatAngled, textSeat),
    ButtonItem(Icons.Default.Backpack, textBaggage),
    ButtonItem(Icons.Default.HdrPlus, textAdditionalService)
)

val buttonListBottomRow = listOf<ButtonItem>(
    ButtonItem(Icons.Default.Assignment, textFlightAssistant),
    ButtonItem(Icons.Default.AirplaneTicket, textBarcodeScreen),
    ButtonItem(Icons.Default.AddShoppingCart, textCampaigns),
    ButtonItem(Icons.Default.More, textMore)
)