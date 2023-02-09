package com.example.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationDemo_Version01() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = "FirstScreen") {
        composable(route = "FirstScreen") { Screen1(navHostController) }
        composable(route = "SecondScreen") { Screen2() }
    }

}

@Composable
private fun Screen1(navHostController: NavHostController) {
    Column() {
        Text(text = "This is main  Screen")
        Button(onClick = { navHostController.navigate("SecondScreen") }) {
            Icon(imageVector = Icons.Default.Send, contentDescription = null)
            Text(text = "go to Next Screen")
        }
    }

}

@Composable
private fun Screen2() {
    Text(text = "This is Second Screen")
}
