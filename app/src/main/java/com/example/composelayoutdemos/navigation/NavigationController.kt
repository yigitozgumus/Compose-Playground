package com.example.composelayoutdemos.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composelayoutdemos.EntryScreen

@Composable
fun NavigationController(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DemoScreen.Entry.name,
        modifier = modifier
    ) {
        composable(DemoScreen.Entry.name) {
            EntryScreen()
        }
    }
}