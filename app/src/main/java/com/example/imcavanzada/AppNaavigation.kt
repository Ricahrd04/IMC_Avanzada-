package com.example.imcavanzada

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController =
        rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Inicio"
    ){
        composable("Inicio"){
            Pantalla_Inicio(
                navController = navController
            )
        }
        composable  (
            route = "resultado/{nombre}/{imc}",
            arguments =  listOf(
                navArgument("nombre"){
                    type = NavType.StringType
                },
                navArgument("imc"){
                    type = NavType.StringType
                }
            )
        ){ backStackEntry ->
            val nombre =
                backStackEntry.arguments
                    ?.getString("nombre")
                    ?:""

            val imc =
                backStackEntry.arguments
                    ?.getString("imc")
                    ?.toDoubleOrNull()
                    ?: 0.0
            PantallaResultado(
                navController = navController,
                nombre = nombre,
                imc = imc
            )
        }
    }
}