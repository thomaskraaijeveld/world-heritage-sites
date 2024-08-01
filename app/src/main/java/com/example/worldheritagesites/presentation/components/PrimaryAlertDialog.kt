package com.example.worldheritagesites.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.worldheritagesites.R

@Composable
fun PrimaryAlertDialog(
    onDismissRequest: () -> Unit,
    text: String
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = stringResource(R.string.button_ok))
            }
        },
        text = { Text(text = text) },
    )
}

@Preview
@Composable
private fun PrimaryAlertDialogPreview() = PrimaryAlertDialog(
    onDismissRequest = {},
    text = stringResource(R.string.unknown_error_text)
)