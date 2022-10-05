package com.grubclub

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.grubclub.composable.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                ) {
                    NavHost(navController, "Add") {
                        composable("Home") { HomeScreen(navController) }
                        composable("Map") { MapScreen(navController) }
                        composable("History") { HistoryScreen(navController) }
                        composable("Basket") { BasketScreen(navController) }
                        composable("Add") { AddScreen(navController) }
                    }
                }
            }
            Box(Modifier.fillMaxSize()) {
                Box(Modifier.align(Alignment.BottomCenter)) {
                    BottomNav(navController)
                }
            }
        }
    }
}