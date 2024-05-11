package org.d3if3092.asesmenmobpro2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.d3if3092.assesment2.navigation.Screen
import com.example.d3if3092.assesment2.ui.theme.screen.DetailScreen
import com.example.d3if3092.assesment2.ui.theme.screen.KEY_ID_PEMINJAMANBARANG
import org.d3if3092.asesmenmobpro2.ui.screen.MainScreen


@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route){
            MainScreen(navController)
        }
        composable(route = Screen.FromBaru.route){
            DetailScreen(navController)
        }
        composable(
            route = Screen.FromUbah.route,
            arguments = listOf(
                navArgument(KEY_ID_PEMINJAMANBARANG) {type = NavType.LongType}
            )
        ) {navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getLong(KEY_ID_PEMINJAMANBARANG)
            DetailScreen(navController, id)
        }
    }
}