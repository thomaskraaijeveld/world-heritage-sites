package com.example.worldheritagesites.presentation.screens.worldheritagesites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldheritagesites.domain.usecases.GetWorldHeritageSitesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class WorldHeritageSitesViewModel @Inject constructor(
    private val getWorldHeritageSitesUseCase: GetWorldHeritageSitesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(WorldHeritageSitesUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getWorldHeritageSites("")
    }

    private fun getWorldHeritageSites(searchQuery: String) = viewModelScope.launch {
        try {
            val worldHeritageSites = withContext(Dispatchers.IO) {
                getWorldHeritageSitesUseCase(searchQuery)
            }
            _uiState.value = _uiState.value.copy(worldHeritageSites = worldHeritageSites)
        } catch (exception: Exception) {
            onShowErrorDialog(exception)
        } finally {
            _uiState.value = _uiState.value.copy(showLoading = false)
        }
    }

    fun onSearchQueryChanged(searchQuery: String) {
        _uiState.value = _uiState.value.copy(searchQuery = searchQuery)
        getWorldHeritageSites(searchQuery)
    }

    fun onShowErrorDialog(exception: Exception?) {
        _uiState.value = _uiState.value.copy(showErrorDialog = exception)
    }
}