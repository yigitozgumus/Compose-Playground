package com.example.composelayoutdemos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composelayoutdemos.navigation.DemoScreen
import com.example.composelayoutdemos.navigation.NavigationController
import com.example.composelayoutdemos.ui.theme.ComposeLayoutDemosTheme
import com.google.android.material.tabs.TabLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutDemoApp()
        }
    }
}

@Composable
fun ComposeLayoutDemoApp() {
    val allScreens = DemoScreen.values().toList()
    val navController = rememberNavController()
    val backstackEntry = navController.currentBackStackEntryAsState()

    val currentScreen = DemoScreen.fromRoute(
        backstackEntry.value?.destination?.route
    )
    Scaffold(
        topBar = {
            DemoTabRow()
        }
    ) { innerPadding ->
        NavigationController(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun DemoTabRow() {
    Surface(
        modifier = Modifier.height(TabHeight).fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(4.dp),
            text = "Layout Demo Screen",
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun DemoTabRowPreview(){
    DemoTabRow()
}

@Composable
fun EntryScreen() {
    Text("Hello")
}

val TabHeight = 20.dp
