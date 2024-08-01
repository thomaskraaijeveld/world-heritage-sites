package com.example.worldheritagesites.presentation.screens.worldheritagesites

import com.example.worldheritagesites.domain.models.WorldHeritageSite

data class WorldHeritageSitesUiState(
    val worldHeritageSites: List<WorldHeritageSite> = emptyList(),
    val showLoading: Boolean = false,
    val showErrorDialog: Exception? = null
)