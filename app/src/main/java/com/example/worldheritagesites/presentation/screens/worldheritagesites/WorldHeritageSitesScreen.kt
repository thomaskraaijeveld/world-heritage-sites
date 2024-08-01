package com.example.worldheritagesites.presentation.screens.worldheritagesites

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.worldheritagesites.R
import com.example.worldheritagesites.domain.models.WorldHeritageSite
import com.example.worldheritagesites.presentation.components.PrimaryAlertDialog
import com.example.worldheritagesites.presentation.preview.SampleData.sampleWorldHeritageSite
import com.example.worldheritagesites.presentation.screens.worldheritagesites.components.WorldHeritageSiteListItem

@Composable
fun WorldHeritageSitesScreen(viewModel: WorldHeritageSitesViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    WorldHeritageSitesLayout(
        worldHeritageSites = uiState.worldHeritageSites,
        showLoading = uiState.showLoading
    )

    uiState.showErrorDialog?.let { exception ->
        PrimaryAlertDialog(
            onDismissRequest = { viewModel.onShowErrorDialog(null) },
            text = exception.localizedMessage ?: stringResource(R.string.unknown_error_text)
        )
    }
}

@Composable
private fun WorldHeritageSitesLayout(
    worldHeritageSites: List<WorldHeritageSite>,
    showLoading: Boolean
) {
    val lazyListState = rememberLazyListState()
    Crossfade(
        targetState = showLoading,
        label = "",
    ) {
        if (it) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        } else {
            LazyColumn(
                state = lazyListState,
                modifier = Modifier.fillMaxSize()
            ) {
                items(worldHeritageSites) { worldHeritageSite ->
                    WorldHeritageSiteListItem(worldHeritageSite)
                    HorizontalDivider()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun WorldHeritageSitesLayoutPreview() = WorldHeritageSitesLayout(
    worldHeritageSites = listOf(
        sampleWorldHeritageSite,
        sampleWorldHeritageSite,
        sampleWorldHeritageSite,
        sampleWorldHeritageSite
    ),
    showLoading = false
)