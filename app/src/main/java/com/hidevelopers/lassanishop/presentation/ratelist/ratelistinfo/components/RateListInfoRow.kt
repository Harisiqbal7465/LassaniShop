package com.hidevelopers.lassanishop.presentation.ratelist.ratelistinfo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun RateListInfoRow(
    rateListName: String,
    rateListSize: Long,
    rowIndex: Long,
    navigate: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { navigate() },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$rateListName ($rateListSize)",
            style = MaterialTheme.typography.h1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}