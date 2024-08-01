package com.example.worldheritagesites.presentation.navigation

sealed class Screen(val route: String) {
    data object WorldHeritageSites : Screen("worldheritagesites")
}