package com.example.worldheritagesites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.worldheritagesites.presentation.navigation.Screen
import com.example.worldheritagesites.presentation.screens.worldheritagesites.WorldHeritageSitesScreen
import com.example.worldheritagesites.presentation.theme.WorldHeritageSitesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorldHeritageSitesTheme {
                val navController = rememberNavController()
                Scaffold { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.WorldHeritageSites.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(route = Screen.WorldHeritageSites.route) { WorldHeritageSitesScreen() }
                    }
                }
            }
        }
    }
}