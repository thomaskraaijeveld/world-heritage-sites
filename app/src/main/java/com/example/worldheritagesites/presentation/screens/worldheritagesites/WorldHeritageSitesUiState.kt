package com.example.worldheritagesites.presentation.screens.worldheritagesites

import com.example.worldheritagesites.domain.models.WorldHeritageSite

data class WorldHeritageSitesUiState(
    val searchQuery: String = "",
    val worldHeritageSites: List<WorldHeritageSite> = emptyList(),
    val showLoading: Boolean = true,
    val showErrorDialog: Exception? = null
)