package com.example.composelayoutdemos.navigation.topics.pegasus

import androidx.annotation.DrawableRes
import com.example.composelayoutdemos.R

data class ButtonItem(@DrawableRes val icon: Int, val description: String)

val buttonListTopRow = listOf<ButtonItem>(
    ButtonItem(R.drawable.icons_home_bol_bol, textBolbol),
    ButtonItem(R.drawable.icons_home_seat, textSeat),
    ButtonItem(R.drawable.icons_home_baggage, textBaggage),
    ButtonItem(R.drawable.icons_home_extras, textAdditionalService)
)

val buttonListBottomRow = listOf<ButtonItem>(
    ButtonItem(R.drawable.icons_home_my_trips, textFlightAssistant),
    ButtonItem(R.drawable.icons_home_boarding_pass, textBarcodeScreen),
    ButtonItem(R.drawable.icons_home_offers, textCampaigns),
    ButtonItem(R.drawable.icons_home_more, textMore)
)