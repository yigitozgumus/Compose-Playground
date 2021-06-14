package com.example.composelayoutdemos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composelayoutdemos.navigation.topics.CardScreen
import com.example.composelayoutdemos.navigation.topics.LayoutScreen
import com.example.composelayoutdemos.navigation.topics.PegasusHomeScreen
import com.example.composelayoutdemos.navigation.topics.TextScreen
import com.example.composelayoutdemos.ui.theme.ComposeLayoutDemosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutDemosTheme {
                PlaygroundApp()
            }
        }
    }
}

enum class Topics {
    Entry,
    Cards,
    Text,
    Layouts,
    Pegasus

}

@Composable
fun PlaygroundApp() {
    val allScreens = Topics.values()
    val navController = rememberNavController()
    val backstackEntry = navController.currentBackStackEntryAsState()
    Scaffold { innerPadding ->
        PlaygroundNavigation(
            navController = navController,
            modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun PlaygroundNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Topics.Entry.name,
        modifier = modifier
    ) {
        Topics.values().map { topic ->
            composable(topic.name) {
                returnMappedTopicScreen(topic = topic, navRef = navController)
            }
        }
    }
}
@Composable
fun returnMappedTopicScreen(topic: Topics, navRef: NavHostController) {
    val navigation = {topic: String ->  navRef.navigate(topic) }
    when(topic.name) {
        Topics.Entry.name -> EntryScreen(onTopicClicked = navigation)
        Topics.Cards.name -> CardScreen()
        Topics.Layouts.name -> LayoutScreen()
        Topics.Text.name -> TextScreen()
        Topics.Pegasus.name -> PegasusHomeScreen()
    }
}

@Composable
fun EntryScreen(onTopicClicked: (String) -> Unit) {
    Scaffold(
        topBar = {
            Text(
                text = "Compose Playground",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    ) {
        LazyColumn() {
            items(Topics.values().filterNot{it.name == Topics.Entry.name}, null, {
                Topic(it.name, onTopicClicked)
            })
        }
    }
}

@Composable
fun Topic(topicName: String, onTopicClicked: (String) -> Unit) {
    Button(
        onClick = { onTopicClicked(topicName) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = topicName)
    }
}

@Preview
@Composable
fun topicPreview(){
    Topic(Topics.Cards.name, {})
}

