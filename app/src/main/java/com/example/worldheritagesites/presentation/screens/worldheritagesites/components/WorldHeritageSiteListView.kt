package com.example.worldheritagesites.presentation.screens.worldheritagesites.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.worldheritagesites.R
import com.example.worldheritagesites.domain.models.WorldHeritageSite
import com.example.worldheritagesites.presentation.preview.SampleData.sampleWorldHeritageSite

@Composable
fun WorldHeritageSiteListView(
    lazyListState: LazyListState,
    worldHeritageSites: List<WorldHeritageSite>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        state = lazyListState,
        modifier = modifier.fillMaxSize()
    ) {
        items(worldHeritageSites) { worldHeritageSite ->
            WorldHeritageSiteListItem(worldHeritageSite)
            HorizontalDivider()
        }
        if (worldHeritageSites.isEmpty()) {
            item {
                Text(
                    text = stringResource(R.string.world_heritage_sites_empty),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WorldHeritageSiteListViewPreview() = WorldHeritageSiteListView(
    lazyListState = rememberLazyListState(),
    worldHeritageSites = listOf(
        sampleWorldHeritageSite,
        sampleWorldHeritageSite,
        sampleWorldHeritageSite,
        sampleWorldHeritageSite
    )
)