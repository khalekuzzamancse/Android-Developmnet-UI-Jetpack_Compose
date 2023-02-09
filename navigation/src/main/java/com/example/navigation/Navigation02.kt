package com.example.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavigationDemo_Version02() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = "FirstScreen") {
        composable(route = "FirstScreen") { Screen1(navHostController) }
        composable(
            route = "SecondScreen/{a}/{b}",
            arguments = listOf
                (
                navArgument("a") { type = NavType.IntType },
                navArgument("b") { type = NavType.IntType }
            )
        ) {
            val a = it.arguments?.getInt("a") ?: 0
            val b = it.arguments?.getInt("b") ?: 0
            Screen2(a, b)
        }
    }

}

@Composable
private fun Screen2(a: Int, b: Int) {
    Column() {
        Text(text = "This is Second Screen")
        Text(text = "Passed Data is: ${a},${b}")
    }

}

@Composable
private fun Screen1(navHostController: NavHostController) {
    Column() {
        Text(text = "This is main  Screen")
        Button(onClick = { navHostController.navigate("SecondScreen/10/30") }) {
            Icon(imageVector = Icons.Default.Send, contentDescription = null)
            Text(text = "go to Next Screen")
        }
    }

}

