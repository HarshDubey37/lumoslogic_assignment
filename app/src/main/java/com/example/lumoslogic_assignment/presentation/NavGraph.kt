package com.example.lumoslogic_assignment.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController, startDestination = "list") {

        composable("list") {
            PostListScreen(navController)
        }

        composable("detail/{id}") { backStack ->
            val id = backStack.arguments?.getString("id")?.toInt() ?: 0
            PostDetailScreen(id)
        }
    }
}