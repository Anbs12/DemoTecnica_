package com.example.demotecnica_.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demotecnica_.ui.screens.IndividualUserScreen
import com.example.demotecnica_.ui.screens.MainSscreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.Main.name,
        modifier = modifier
    ) {

        //Lista de usuarios.
        composable(
            route = Routes.Main.name
        ) {
            MainSscreen() { userId ->
                navController.navigate(route = Routes.SpecificUser.name + "/$userId")
            }
        }

        //User unico seleccionado.
        composable(
            route = Routes.SpecificUser.name + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt("id") ?: 0
            IndividualUserScreen(id = id)
        }
    }
}