package com.example.composelayoutdemos.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector

enum class DemoScreen(val icon: ImageVector? = null) {
    Entry();

    companion object {
        fun fromRoute(route: String?): DemoScreen =
            when (route?.substringBefore("/")) {
                Entry.name -> Entry
                null -> Entry
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}