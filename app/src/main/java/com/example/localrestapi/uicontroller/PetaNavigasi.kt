package com.example.localrestapi.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.localrestapi.uicontroller.route.DestinasiDetail
import com.example.localrestapi.uicontroller.route.DestinasiEdit
import com.example.localrestapi.uicontroller.route.DestinasiEntry
import com.example.localrestapi.uicontroller.route.DestinasiHome
import com.example.localrestapi.view.DetailSiswaScreen
import com.example.localrestapi.view.EditSiswaScreen
import com.example.localrestapi.view.EntrySiswaScreen
import com.example.localrestapi.view.HomeScreen

@Composable
fun DataSiswaApp(
    modifier: Modifier = Modifier, // Modifier sekarang menjadi parameter opsional pertama
    navController: NavHostController = rememberNavController()
) {
    // Meneruskan modifier ke HostNavigasi
    HostNavigasi(navController = navController, modifier = modifier)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier // Menggunakan modifier pada NavHost
    ) {
        // Rute Halaman Utama
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { id ->
                    navController.navigate("${DestinasiDetail.route}/$id")
                }
            )
        }

        // Rute Tambah Siswa
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = {
                navController.popBackStack(DestinasiHome.route, false)
            })
        }

        // Rute Detail Siswa
        composable(
            route = DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.ITEM_ID_ARG) {
                type = NavType.IntType
            })
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { id ->
                    navController.navigate("${DestinasiEdit.route}/$id")
                },
                navigateBack = { navController.navigateUp() }
            )
        }

        // Rute Edit Siswa
        composable(
            route = DestinasiEdit.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEdit.ITEM_ID_ARG) {
                type = NavType.IntType
            })
        ) {
            EditSiswaScreen(
                navigateBack = {
                    navController.popBackStack(DestinasiHome.route, false)
                },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}