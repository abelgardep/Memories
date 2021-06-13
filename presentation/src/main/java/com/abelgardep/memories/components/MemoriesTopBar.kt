package com.abelgardep.memories.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun BaseTopBar(
    modifier: Modifier = Modifier,
    title: @Composable RowScope.() -> Unit,
    navigationIcon: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = { Row { title() } },
        actions = actions,
        navigationIcon = navigationIcon
    )
}

@Composable
fun BackIcon(
    onBackClick: () -> Unit
) {
    IconButton(onClick = { onBackClick() }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null
        )
    }
}

@Composable
fun ActionEdit(
    onEditClick: () -> Unit
) {
    IconButton(onClick = { onEditClick() }) {
        Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = null
        )
    }
}
