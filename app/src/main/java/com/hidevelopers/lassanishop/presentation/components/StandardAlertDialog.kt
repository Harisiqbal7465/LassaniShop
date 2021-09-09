package com.hidevelopers.lassanishop.presentation.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

@Composable
fun StandardAlertDialog(
    openDialog: (Boolean) -> Unit,
    title: @Composable () -> Unit,
    text: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    dismissButton: @Composable (() -> Unit)? = null,
    confirmButton: @Composable () -> Unit
) {
    AlertDialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onCloseRequest.
            openDialog(false)
        },
        modifier = modifier,
        title = title,
        text = text,
        shape = shape,
        backgroundColor = backgroundColor,
        confirmButton = { confirmButton() },
        dismissButton = {
            dismissButton?.let {
                dismissButton()
            }
        }
    )
}