package com.example.localrestapi.uicontroller

import androidx.compose.runtime.Composable

@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier){
    HostNavigasi(navController = navController)
}